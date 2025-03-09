package lecture.cordingTest.ch1;

import lecture.cordingTest.ch2String.문자찾기_1;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class 문자찾기Test {

    @DisplayName("")
    @Test
    void test585(){
        // given
        문자찾기_1 findWord = new 문자찾기_1();
        int word = findWord.findWord("abcabca", 'a');
        // when

        char[] charArray = "st".toCharArray();
        char c = charArray[0];

        // then
        Assertions.assertThat(word).isEqualTo(3);
    }

}