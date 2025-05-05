package developx.lecture.adv3.parallel;

import developx.lecture.adv3.util.MyLogger;

import java.util.stream.IntStream;

public class ParallelMain1 {

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();

        int sum = IntStream.rangeClosed(1, 8)
                .map(HeavyJob::heavyTask).reduce(0, (left, right) -> left+ right);

        long endTime = System.currentTimeMillis();
        MyLogger.log("time: " + (endTime - startTime) + "ms, sum: " + sum);
    }
}
