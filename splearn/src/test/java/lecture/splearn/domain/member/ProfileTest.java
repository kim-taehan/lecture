package lecture.splearn.domain.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ProfileTest {
    @Test
    void profile() {
        new Profile("tobyilee");
        new Profile("kimtaehan");
        new Profile("toby1000");
        new Profile("12345");
        new Profile("");
    }
    
    @Test
    void profileFail() {
        Assertions.assertThatThrownBy(() -> new Profile("프로필")).isInstanceOf(IllegalArgumentException.class);
        Assertions.assertThatThrownBy(() -> new Profile("@@@1111")).isInstanceOf(IllegalArgumentException.class);
        Assertions.assertThatThrownBy(() -> new Profile("s".repeat(16))).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void url() {
        var profile = new Profile("test");

        assertThat(profile.url()).isEqualTo("@test");
    }
}