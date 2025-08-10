package lecture.splearn.application.provided;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import jakarta.validation.ConstraintViolationException;
import lecture.splearn.SplearnTestConfiguration;
import lecture.splearn.domain.*;
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
        Member member = memberRegister.register(MemberFixture.createMemberRegisterRequest());
        entityManager.flush();
        entityManager.clear();

        member = memberRegister.activate(member.getId());
        entityManager.flush();

        assertThat(member.getStatus()).isEqualTo(MemberStatus.ACTIVE);
    }

}