package lecture.splearn.adapter.integration;

import lecture.splearn.application.required.EmailSender;
import lecture.splearn.domain.Email;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Fallback;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Fallback
public class DummyEmailSender implements EmailSender {

    @Override
    public void send(Email email, String subject, String body) {
        log.info("dummy email sender ={}", email);
    }
}
