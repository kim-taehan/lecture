package developx.lecture.adv3.ch5.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class MyStreamV1 {

    private List<Integer> internalList;

    public MyStreamV1(List<Integer> internalList) {
        this.internalList = internalList;
    }

    public MyStreamV1 filter(Predicate<Integer> predicate) {
        List<Integer> ret = new ArrayList<>();
        for (Integer i : internalList) {
            if (predicate.test(i)) {
                ret.add(i);
            }
        }
        return new MyStreamV1(ret);
    }

    public MyStreamV1 map(Function<Integer, Integer> mapper) {
        List<Integer> ret = new ArrayList<>();
        for (Integer i : internalList) {
            ret.add(mapper.apply(i));
        }
        return new MyStreamV1(ret);
    }

    public List<Integer> toList() {
        return internalList;
    }

    public static void main(String[] args) {
        List<Integer> list = List.of(1, 2, 3, 4, 5, 6);

        List<Integer> list1 = new MyStreamV1(list)
                .filter(integer -> integer % 2 == 0)
                .map(integer -> integer * 2)
                .toList();

        System.out.println("list1 = " + list1);
    }
}
