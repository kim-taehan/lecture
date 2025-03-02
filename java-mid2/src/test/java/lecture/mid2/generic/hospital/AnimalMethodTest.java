package lecture.mid2.generic.hospital;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AnimalMethodTest {

    @DisplayName("generic method 를 사용해서 고양이소리 듣기")
    @Test
    void checkUp(){
        // given
        Cat cat = new Cat();

        // when
        String sound = AnimalMethod.checkup(cat);

        // then
        Assertions.assertEquals(sound, "야옹");
    }
    
}