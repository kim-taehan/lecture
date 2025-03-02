package lecture.mid2.comparable;

import java.util.Comparator;

public class IdComparator implements Comparator<MyUser> {
    @Override
    public int compare(MyUser o1, MyUser o2) {
        return Integer.compare(o1.getAge(), o2.getAge());
    }
}
