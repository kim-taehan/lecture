package developx.lecture.adv3.ch5.filter;

import java.util.ArrayList;
import java.util.List;
import java.util.function.IntFunction;
import java.util.function.Predicate;

public class OddFilter {
    public static void main(String[] args) {

        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);


        Predicate<Integer> odd = value -> value % 2 == 1;


        List<Integer> filter = filter(numbers, odd);
        System.out.println("evenNumbers = " + filter);


    }

    static List<Integer> filter(List<Integer> numbers, Predicate<Integer> predicate) {
        List<Integer> filtered = new ArrayList<>();
        for (Integer number : numbers) {
            if (predicate.test(number)) {
                filtered.add(number);
            }
        }
        return filtered;
    }


}
