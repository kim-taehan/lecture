package lecture.mid2.generic.hospital;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AnimalHospitalTest {
    
    @DisplayName("Dog hospital 에서는 `멍멍` 소리가 발생한다.")
    @Test
    void sound(){
        // given
        Dog dog = new Dog();
        
        // when
        String sound = dog.sound();
        
        // then
        Assertions.assertEquals(sound, "멍멍");
    }
    

}