package developx.lecture.adv3.collectors;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Collectors2Map {

    public static void main(String[] args) {
        Map<String, Integer> collect = Stream.of("사과", "바나나", "토마토")
                .collect(Collectors.toMap(name -> name, name -> name.length()));

        System.out.println("collect = " + collect);


        Map<String, Integer> collect2 = Stream.of("사과", "사과", "토마토")
                .collect(Collectors.toMap(name -> name, name -> name.length(), (o, o2) -> o + o2, LinkedHashMap::new));
        System.out.println("collect2 = " + collect2);


        Stream<String> names = Stream.of("Apple", "Avocado", "Banana", "Cherry");

        Map<Boolean, List<String>> a = names.collect(Collectors.groupingBy(s -> s.startsWith("A")));

        System.out.println("a = " + a);


        Map<String, List<String>> collect1 =  Stream.of("Apple", "Avocado", "Banana", "Cherry")
                .collect(Collectors.groupingBy(s -> s.substring(0, 1)));
        System.out.println("collect1 = " + collect1);


        Map<Boolean, List<Integer>> collect3 = Stream.of(1, 2, 3, 4, 5, 6).collect(Collectors.partitioningBy(integer -> integer > 3));
        System.out.println("collect3 = " + collect3);






    }
}
