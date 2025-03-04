package lecture.cordingTest.ch1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FindWordTest {

    @DisplayName("")
    @Test
    void test585(){
        // given
        FindWord findWord = new FindWord();
        int word = findWord.findWord("abcabca", 'a');
        // when

        char[] charArray = "st".toCharArray();
        char c = charArray[0];

        // then
        Assertions.assertThat(word).isEqualTo(3);
    }

}