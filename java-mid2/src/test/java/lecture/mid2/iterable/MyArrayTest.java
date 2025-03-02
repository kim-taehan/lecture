package lecture.mid2.iterable;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MyArrayTest {


    @DisplayName("iterator 를 통해 순차적으로 데이터를 보여줄 수 있다.")
    @Test
    void iterator(){
        // given
        int[] array = {10, 20, 30};
        MyArray myArray = new MyArray(array);

        // when
        Iterator<Integer> iterator = myArray.iterator();
        while (iterator.hasNext()) {
            System.out.println("iterator.next() = " + iterator.next());
        }
    }

}