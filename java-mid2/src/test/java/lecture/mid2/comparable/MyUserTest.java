package lecture.mid2.comparable;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MyUserTest {

    @DisplayName("Comparable 를 통해 정렬할 수 있다.")
    @Test
    void test68(){
        // given
        List<MyUser> myUserList = new ArrayList<>();
        myUserList.add(new MyUser(10, 12));
        myUserList.add(new MyUser(20, 3));
        myUserList.add(new MyUser(10, 5));

        System.out.println(myUserList);
        // when
        myUserList.sort(null);
        System.out.println(myUserList);

        // then
    }

    @DisplayName("Comparator 를 통해 다른 방법으로 정렬한다.")
    @Test
    void test239(){
        List<MyUser> myUserList = new ArrayList<>();
        myUserList.add(new MyUser(10, 12));
        myUserList.add(new MyUser(20, 3));
        myUserList.add(new MyUser(10, 5));

        System.out.println(myUserList);
        // when
        myUserList.sort(new IdComparator());
        System.out.println(myUserList);
        // then
        Assertions.assertThat("");
    }


}