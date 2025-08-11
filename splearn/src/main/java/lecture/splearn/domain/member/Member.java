package lecture.splearn.domain.member;

import jakarta.persistence.*;
import lecture.splearn.domain.AbstractEntity;
import lecture.splearn.domain.shared.Email;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.NaturalId;
import org.hibernate.annotations.NaturalIdCache;

import java.util.Objects;

import static java.util.Objects.requireNonNull;
import static org.springframework.util.Assert.state;

@Entity
@Getter
@ToString(callSuper = true, exclude = "detail")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@NaturalIdCache
@Table(name = "MEMBER", uniqueConstraints =
        @UniqueConstraint(name = "UK_MEMBER_EMAIL_ADDRESS", columnNames = "email_address")
)
public class Member extends AbstractEntity {

    @Embedded
    @NaturalId
    private Email email;

    @Column(length = 100, nullable = false)
    private String nickname;

    @Column(length = 200, nullable = false)
    private String passwordHash;

    @Column(length = 50, nullable = false)
    @Enumerated(EnumType.STRING)
    private MemberStatus status;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "detail_id")
    private MemberDetail detail;

    public static Member register(MemberRegisterRequest request, PasswordEncoder encoder){
        Member member = new Member();
        member.email = new Email(request.email());
        member.nickname = request.nickname();
        member.passwordHash = encoder.encode(request.password());
        member.status = MemberStatus.PENDING;

        member.detail = MemberDetail.create();
        return member;
    }

    public void activate() {
        state(this.status == MemberStatus.PENDING, "PENDING 상태가 아닙니다.");
        this.status = MemberStatus.ACTIVE;
        this.detail.activate();
    }

    public void deactivate() {
        state(this.status == MemberStatus.ACTIVE, "ACTIVE 상태가 아닙니다.");
        this.status = MemberStatus.DEACTIVATED;
        this.detail.deactivate();
    }

    public boolean verifyPassword(String password, PasswordEncoder passwordEncoder) {
        return passwordEncoder.matches(password, this.passwordHash);
    }

    public void updateInfo(MemberInfoUpdateRequest updateRequest) {
        state(this.status == MemberStatus.ACTIVE, "ACTIVE 상태가 아닙니다.");
        this.nickname = Objects.requireNonNull(updateRequest.nickname());

        this.detail.updateInfo(updateRequest);
    }


    public void changePassword(String password, PasswordEncoder encoder) {
        this.passwordHash = encoder.encode(
                requireNonNull(password)
        );
    }

    public boolean isActive() {
        return this.status == MemberStatus.ACTIVE;
    }
}
