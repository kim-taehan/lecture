package developx.lecture.adv3.collectors;

import java.util.Collections;
import java.util.IntSummaryStatistics;
import java.util.OptionalDouble;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Collectors4MinMax {


    public static void main(String[] args) {
        Integer max1 = Stream.of(1, 2, 3).collect(Collectors.maxBy((o1, o2) -> o1.compareTo(o2))).get();
        System.out.println("max1 = " + max1);


        Long collect = Stream.of(1, 2, 3).collect(Collectors.counting());
        System.out.println("collect = " + collect);


        Double avg = Stream.of(1, 2, 3).collect(Collectors.averagingInt(i -> i));
        System.out.println("avg = " + avg);
        OptionalDouble average = Stream.of(1, 2, 3).mapToInt(i -> i).average();
        System.out.println("average.getAsDouble() = " + average.getAsDouble());


        // 통계
        IntSummaryStatistics collect1 = Stream.of("apple", "banana", "tomato")
                .collect(Collectors.summarizingInt(value -> value.length()));

        System.out.println("collect1 = " + collect1);


        String s1 = Stream.of("a", "b", "c", "d")
                .collect(Collectors.reducing((s, s2) -> s + ", " + s2)).get();

        System.out.println(s1);


    }
}
