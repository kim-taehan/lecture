package lecture.mid2.comparable;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class MyUser implements Comparable<MyUser> {

    private final int age;
    private final int birthMonth;

    @Override
    public int compareTo(MyUser o) {
        int compare = Integer.compare(this.age, o.age);
        if (compare == 0) {
            return Integer.compare(this.birthMonth, o.birthMonth);
        }
        return compare;
    }

    @Override
    public String toString() {
        return "age=" + age +
                ", birthMonth=" + birthMonth
                ;
    }
}
