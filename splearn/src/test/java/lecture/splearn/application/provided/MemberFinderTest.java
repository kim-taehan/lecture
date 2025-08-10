package lecture.splearn.application.provided;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lecture.splearn.SplearnTestConfiguration;
import lecture.splearn.domain.Member;
import lecture.splearn.domain.MemberFixture;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Import(SplearnTestConfiguration.class)
@Transactional
record MemberFinderTest(MemberFinder memberFinder, MemberRegister memberRegister, EntityManager entityManager) {

    @Test
    void find() {
        Member member = memberRegister.register(MemberFixture.createMemberRegisterRequest());
        entityManager.flush();
        entityManager.clear();

        Member findMember = memberFinder.find(member.getId());

        assertThat(member.getId()).isEqualTo(findMember.getId());
    }

    @Test
    void findFail() {
        Assertions.assertThatThrownBy(() -> memberFinder.find(999L))
            .isInstanceOf(IllegalArgumentException.class);
    }
}