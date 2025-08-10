package lecture.splearn;

import lecture.splearn.application.required.EmailSender;
import lecture.splearn.domain.MemberFixture;
import lecture.splearn.domain.PasswordEncoder;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

@TestConfiguration
public class SplearnTestConfiguration {
    @Bean
    public EmailSender emailSender() {
        return (email, subject, body) -> System.out.println("email = " + email);
    }

    @Bean
    public static PasswordEncoder passwordEncoder() {
        return MemberFixture.createPasswordEncoder();
    }
}
