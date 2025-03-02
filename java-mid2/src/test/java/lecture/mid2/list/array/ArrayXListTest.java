package lecture.mid2.list.array;

import lecture.mid2.list.XList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class ArrayXListTest {

    @DisplayName("배열의 사이즈가 가득차면 크기를 증가시켜서 add 할 수 있게 한다.")
    @Test
    void addIfFullSize(){
        // given
        XList<String> items = new ArrayXList<>(3);

        // when
        items.add("red");
        items.add("blue");
        items.add("white");
        items.add("black");

        // then
        assertThat(items.size()).isEqualTo(4);
    }

    @DisplayName("특정 인덱스에 있는 데이터를 조회할 수 있다.")
    @Test
    void getIndex(){
        // given
        XList<String> items = new ArrayXList<>(3);
        items.add("red");
        items.add("blue");
        items.add("white");

        // when & then
        assertThat(items.getIndex(2)).isEqualTo("white");
    }

    @DisplayName("리스트 중간에 데이터를 입력할 수 있다.")
    @Test
    void put(){
        // given
        XList<String> items = new ArrayXList<>(3);
        items.add("red");
        items.add("blue");
        items.add("white");

        // when
        items.put("black", 2);

        // then
        assertThat(items.getIndex(2)).isEqualTo("black");
    }


    @DisplayName("특정 아이템을 제거할 수 있다.")
    @Test
    void remove(){
        // given
        XList<String> items = new ArrayXList<>(3);
        items.add("red");
        items.add("blue");
        items.add("white");

        // when
        String removedItem = items.remove(1);
        // then
        assertThat(removedItem).isEqualTo("blue");
        assertThat(items.size()).isEqualTo(2);
    }
}