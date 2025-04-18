package developx.lecture.adv3.stream;

import java.util.IntSummaryStatistics;
import java.util.stream.IntStream;

public class PrimitiveStreamMain {

    public static void main(String[] args) {

        IntStream.range(1, 10).forEach(System.out::print);
        System.out.println();

        IntStream.rangeClosed(1, 10).forEach(System.out::print);
        System.out.println();


        double asDouble = IntStream.rangeClosed(1, 10).average().getAsDouble();
        System.out.println("asDouble = " + asDouble);


        // 통계
        IntSummaryStatistics intSummaryStatistics = IntStream.rangeClosed(1, 10).summaryStatistics();
        intSummaryStatistics.accept(10);
        intSummaryStatistics.accept(10);

    }
}
