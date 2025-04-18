package developx.lecture.adv3.collectors;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Collectors1 {


    public static void main(String[] args) {

        // 기본 기능
        Set<String> collect = Stream.of("java", "c", "kotlin").collect(Collectors.toSet());
        for (String s : collect) {
            System.out.println("s = " + s);
        }
        List<String> collect1 = Stream.of("java", "c", "kotlin").collect(Collectors.toList());
        for (String s : collect1) {
            System.out.println("s = " + s);
        }


        List<String> collect2 = Stream.of("java", "c", "kotlin").collect(Collectors.toUnmodifiableList());


        TreeSet<Integer> collect3 = Stream.of(1, 5, 2).collect(Collectors.toCollection(TreeSet::new));
        System.out.println("collect3 = " + collect3);


    }
}
