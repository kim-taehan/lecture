package lecture.mid2.set;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class HashXSetTest {

    @DisplayName("HashXSet 에 신규 item 을 입력하고 사이즈를 확인할 수 있다.")
    @Test
    void addAndGetSize(){
        // given
        HashXSet<String> set = new HashXSet<>();

        // when
        set.add("red");
        set.add("blue");

        // then
        assertThat(set.getSize()).isEqualTo(2);
    }


    @DisplayName("set 에 데이터가 있는지 확인할 수 있다.")
    @Test
    void contains(){
        // given
        HashXSet<String> set = new HashXSet<>();
        set.add("red");
        set.add("blue");
        set.add("white");

        set.remove("blue");

        // when & then
        assertAll(
                () -> Assertions.assertThat(set.contains("white")).isTrue(),
                () -> Assertions.assertThat(set.contains("blue")).isFalse()
        );
    }





}