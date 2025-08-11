package lecture.splearn.domain.member;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static lecture.splearn.domain.member.MemberFixture.createMemberRegisterRequest;
import static lecture.splearn.domain.member.MemberFixture.createPasswordEncoder;
import static lecture.splearn.domain.member.MemberStatus.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MemberTest {

    Member member;

    PasswordEncoder passwordEncoder = createPasswordEncoder();

    @BeforeEach
    void beforeEach() {
        member = Member.register(createMemberRegisterRequest(), passwordEncoder);

    }

    @Test
    void registerMember() {
        assertThat(member.getStatus()).isEqualTo(PENDING);
        assertThat(member.getDetail().getRegisteredAt()).isNotNull();
    }


    @Test
    void activate() {

        member.activate();

        assertThat(member.getStatus()).isEqualTo(ACTIVE);
        assertThat(member.getDetail().getActivatedAt()).isNotNull();
    }

    @Test
    void activateFail() {
        member.activate();
        assertThatThrownBy(member::activate)
                .isInstanceOf(IllegalStateException.class);
    }

    @Test
    void deactivate() {
        member.activate();

        member.deactivate();

        assertThat(member.getStatus()).isEqualTo(DEACTIVATED);
        assertThat(member.getDetail().getDeactivatedAt()).isNotNull();
    }

    @Test
    void deactivateFail() {
        assertThatThrownBy(member::deactivate)
                .isInstanceOf(IllegalStateException.class);
    }

    @Test
    void verifyPassword() {
        assertThat(member.verifyPassword("longsecret", passwordEncoder)).isTrue();
        assertThat(member.verifyPassword("hello", passwordEncoder)).isFalse();
    }

    @Test
    void changePassword() {
        member.changePassword("very secret2", passwordEncoder);

        assertThat(member.verifyPassword("very secret2", passwordEncoder)).isTrue();
    }

    @Test
    void shouldBeActive() {
        assertThat(member.isActive()).isFalse();
        member.activate();
        assertThat(member.isActive()).isTrue();
        member.deactivate();
        assertThat(member.isActive()).isFalse();
    }
    
    @Test
    void invalidEmail() {
        assertThatThrownBy(() ->
            Member.register(createMemberRegisterRequest("invalid email"), passwordEncoder)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void updateInfo() {
        member.activate();

        MemberInfoUpdateRequest updateRequest = new MemberInfoUpdateRequest("leo", "toby100", "자기소개");
        member.updateInfo(updateRequest);

        assertThat(member.getNickname()).isEqualTo(updateRequest.nickname());
        assertThat(member.getDetail().getProfile().address()).isEqualTo(updateRequest.profileAddress());
        assertThat(member.getDetail().getIntroduction()).isEqualTo(updateRequest.introduction());
    }

    @Test
    void updateInfoFail() {
        assertThatThrownBy(() -> {
            MemberInfoUpdateRequest updateRequest = new MemberInfoUpdateRequest("leo", "toby100", "자기소개");
            member.updateInfo(updateRequest);
        }).isInstanceOf(IllegalStateException.class);
    }
}