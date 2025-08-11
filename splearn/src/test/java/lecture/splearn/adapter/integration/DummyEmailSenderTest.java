package lecture.splearn.adapter.integration;

import lecture.splearn.domain.shared.Email;
import org.junit.jupiter.api.Test;
import org.junitpioneer.jupiter.StdIo;
import org.junitpioneer.jupiter.StdOut;

import static org.assertj.core.api.Assertions.assertThat;

class DummyEmailSenderTest {

    @Test
    @StdIo
    void dummyEmailSender(StdOut stdOut) {
        DummyEmailSender dummyEmailSender = new DummyEmailSender();

        dummyEmailSender.send(new Email("kimtaehan@gmail.com"), "subject", "body");

        assertThat(stdOut.capturedLines()[0]).contains("dummy email sender =");
    }
}