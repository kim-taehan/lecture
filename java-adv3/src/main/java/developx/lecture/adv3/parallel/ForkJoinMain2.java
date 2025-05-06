package developx.lecture.adv3.parallel;

import developx.lecture.adv3.parallel.forkjoin.SumTask;
import developx.lecture.adv3.util.MyLogger;

import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.IntStream;

import static developx.lecture.adv3.util.MyLogger.log;

public class ForkJoinMain2 {

    public static void main(String[] args) throws InterruptedException {
        List<Integer> data = IntStream.rangeClosed(1, 8)
                .boxed()
                .toList();
        log("[생성] " + data);
        // ForkJoinPool 생성 및 작업 수행
        ForkJoinPool pool = new ForkJoinPool(10);
        long startTime = System.currentTimeMillis();
        SumTask task = new SumTask(data);
        // 병렬로 합을 구한 후 결과 출력
        int result = pool.invoke(task);
        pool.close();
        long endTime = System.currentTimeMillis();
        log("time: " + (endTime - startTime) + "ms, sum: " + result);
        log("pool: " + pool);

    }



}


