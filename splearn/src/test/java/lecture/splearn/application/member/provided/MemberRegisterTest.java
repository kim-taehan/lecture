package lecture.splearn.application.member.provided;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import jakarta.validation.ConstraintViolationException;
import lecture.splearn.SplearnTestConfiguration;
import lecture.splearn.domain.member.*;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@SpringBootTest
@Import(SplearnTestConfiguration.class)
@Transactional
//@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
record MemberRegisterTest(MemberRegister memberRegister, EntityManager entityManager) {

    @Test
    void register() {
        Member member = memberRegister.register(MemberFixture.createMemberRegisterRequest());

        assertThat(member.getId()).isNotNull();
        assertThat(member.getStatus()).isEqualTo(MemberStatus.PENDING);
    }
    
    @Test
    void duplicateEmailFail() {
        memberRegister.register(MemberFixture.createMemberRegisterRequest());

        assertThatThrownBy(() -> memberRegister.register(MemberFixture.createMemberRegisterRequest()))
                .isInstanceOf(DuplicateEmailException.class);

    }

    @Test
    void memberRegisterRequestFail() {
        checkValidation(new MemberRegisterRequest("kimtaehan@gmail.com", "kobe", "longsecret"));
        checkValidation(new MemberRegisterRequest("kimtaehan@gmail.com", "a".repeat(21), "longsecret"));
        checkValidation(new MemberRegisterRequest("kimtaehan.gmail.com", "a".repeat(20), "longsecret"));
    }

    private void checkValidation(MemberRegisterRequest invalid) {
        assertThatThrownBy(() -> memberRegister.register(invalid))
            .isInstanceOf(ConstraintViolationException.class);
    }

    @Test
    void activate() {
        Member member = registerMember();

        member = memberRegister.activate(member.getId());
        entityManager.flush();

        assertThat(member.getStatus()).isEqualTo(MemberStatus.ACTIVE);
        assertThat(member.getDetail().getActivatedAt()).isNotNull();
    }

    @Test
    void deactivate() {
        Member member = registerMember();

        member = memberRegister.activate(member.getId());
        entityManager.flush();
        entityManager.clear();

        Member deactivatedMember = memberRegister.deactivate(member.getId());

        assertThat(deactivatedMember.getStatus()).isEqualTo(MemberStatus.DEACTIVATED);
        assertThat(deactivatedMember.getDetail().getDeactivatedAt()).isNotNull();
    }



    @Test
    void updateInfo() {
        Member member = registerMember();
        member = memberRegister.activate(member.getId());
        entityManager.flush();
        entityManager.clear();

        MemberInfoUpdateRequest memberInfoUpdateRequest = new MemberInfoUpdateRequest("peter", "toby100", "자기소개");
        Member updateMember = memberRegister.updateInfo(member.getId(), memberInfoUpdateRequest);

        assertThat(updateMember.getDetail().getProfile().address()).isEqualTo(memberInfoUpdateRequest.profileAddress());
    }

    @Test
    void updateInfoFail() {
        Member member = registerMember();
        member = memberRegister.activate(member.getId());
        memberRegister.updateInfo(member.getId(), new MemberInfoUpdateRequest("peter", "toby100", "자기소개"));

        Member member2 = registerMember("kimtaehan@sk.com");
        memberRegister.activate(member2.getId());

        entityManager.flush();
        entityManager.clear();

        // member2는 기존의 member와 같은 프로필 주소를 사용하 수 없다
        assertThatThrownBy(() -> memberRegister.updateInfo(member2.getId(), new MemberInfoUpdateRequest("james", "toby100", "자기소개")))
            .isInstanceOf(DuplicateProfileException.class)
                ;

        // 자신의 프로필로 변경가능
        memberRegister.updateInfo(member.getId(), new MemberInfoUpdateRequest("peter", "toby100", "자기소개"));
        // 자신의 프로필을 제거하는 것도 가능
        memberRegister.updateInfo(member.getId(), new MemberInfoUpdateRequest("peter", "", "자기소개"));

    }


    private Member registerMember() {
        Member member = memberRegister.register(MemberFixture.createMemberRegisterRequest());
        entityManager.flush();
        entityManager.clear();
        return member;
    }

    private Member registerMember(String email) {
        Member member = memberRegister.register(MemberFixture.createMemberRegisterRequest(email));
        entityManager.flush();
        entityManager.clear();
        return member;
    }
}