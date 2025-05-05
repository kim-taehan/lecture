package developx.lecture.adv3.parallel;

import developx.lecture.adv3.util.MyLogger;

import java.util.stream.IntStream;

public class ParallelMain2 {

    public static void main(String[] args) throws InterruptedException {
        long startTime = System.currentTimeMillis();

        SumTask sumTask1 = new SumTask(1, 4);
        SumTask sumTask2 = new SumTask(5, 8);

        Thread thread1 = new Thread(sumTask1);
        thread1.start();
        Thread thread2 = new Thread(sumTask2);
        thread2.start();

        thread1.join();
        thread2.join();

        int sum = sumTask1.sum + sumTask2.sum;

        long endTime = System.currentTimeMillis();
        MyLogger.log("time: " + (endTime - startTime) + "ms, sum: " + sum);
    }


    static class SumTask implements Runnable {

        int startValue;
        int endValue;
        int sum;

        public SumTask(int startValue, int endValue) {
            this.startValue = startValue;
            this.endValue = endValue;
        }

        @Override
        public void run() {

            int result = IntStream.rangeClosed(startValue, endValue)
                    .map(HeavyJob::heavyTask).reduce(0, (left, right) -> left + right);
            sum = result;

            MyLogger.log("작업 완료 : " + sum);

        }
    }
}


