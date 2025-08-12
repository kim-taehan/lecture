package lecture.splearn.domain.shared;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class EmailTest {

    @Test
    void equality() {
        var email1 = new Email("toby@naver.com");
        var email2 = new Email("toby@naver.com");

        assertThat(email1).isEqualTo(email2);

    }

}