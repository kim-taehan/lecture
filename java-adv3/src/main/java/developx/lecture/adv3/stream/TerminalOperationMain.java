package developx.lecture.adv3.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class TerminalOperationMain {

    public static void main(String[] args) {

        List<Integer> numbers = List.of(-1, 2, 3, 4, 5, 6);



        Integer[] array = numbers.stream().toArray(Integer[]::new);

        System.out.println("array = " + Arrays.toString(array));

        Stream.of(numbers).count();


        Optional<Integer> reduce = numbers.stream().reduce((integer, integer2) -> integer + integer2);

        System.out.println("reduce.get() = " + reduce.get());


        Integer reduce1 = numbers.stream().reduce(100, (a, b) -> a + b);
        System.out.println("reduce1 = " + reduce1);


        Optional<Integer> min = numbers.stream().min(Integer::compare);
        
        
        // allMatch
        boolean b = numbers.stream().allMatch(value -> value > 0);
        System.out.println("b = " + b);


        boolean b1 = numbers.stream().anyMatch(value -> value < 0);
        System.out.println("b4 = " + b1);


        boolean b4 = numbers.stream().noneMatch(value -> value ==100);
        System.out.println("b4 = " + b4);

    }
}
