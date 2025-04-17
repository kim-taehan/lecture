package developx.lecture.adv3.ch5.filter;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class IntegerFilter {

    public static List<Integer> filter(List<Integer> list, Predicate<Integer> predicate) {
        ArrayList<Integer> ret = new ArrayList<>();
        for (Integer item : list) {
            if (predicate.test(item)) {
                ret.add(item);
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        List<Integer> filter = IntegerFilter.filter(numbers, integer -> integer % 2 == 0);
        System.out.println("filter = " + filter);
    }
}
