package lecture.splearn.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static lecture.splearn.domain.MemberStatus.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MemberTest {

    Member member;

    PasswordEncoder passwordEncoder = new PasswordEncoder() {
        @Override
        public String encode(String password) {
            return password.toUpperCase();
        }

        @Override
        public boolean matches(String password, String passwordHash) {
            return encode(password).equals(passwordHash);
        }
    };

    @BeforeEach
    void beforeEach() {
        member = Member.create(new MemberCreateRequest("kimtaehan11@gmail.com", "kobe", "secret"), passwordEncoder);

    }

    @Test
    void createMember() {
        assertThat(member.getStatus()).isEqualTo(PENDING);
    }


    @Test
    void activate() {

        member.activate();

        assertThat(member.getStatus()).isEqualTo(ACTIVE);
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
    }

    @Test
    void deactivateFail() {
        assertThatThrownBy(member::deactivate)
                .isInstanceOf(IllegalStateException.class);
    }

    @Test
    void verifyPassword() {
        assertThat(member.verifyPassword("secret", passwordEncoder)).isTrue();
        assertThat(member.verifyPassword("hello", passwordEncoder)).isFalse();
    }

    @Test
    void changeNickname() {

        member.changeNickname("taehan");

        assertThat(member.getNickname()).isEqualTo("taehan");

    }

    @Test
    void changePassword() {
        member.changePassword("very secret", passwordEncoder);


        assertThat(member.verifyPassword("very secret", passwordEncoder)).isTrue();
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
            Member.create(new MemberCreateRequest("invalid email", "kobe", "secret"), passwordEncoder)
        ).isInstanceOf(IllegalArgumentException.class);

    }
}