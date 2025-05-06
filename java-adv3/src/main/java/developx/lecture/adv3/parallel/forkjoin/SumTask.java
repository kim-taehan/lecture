package developx.lecture.adv3.parallel.forkjoin;

import developx.lecture.adv3.parallel.HeavyJob;
import developx.lecture.adv3.util.MyLogger;

import java.util.List;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

public class SumTask extends RecursiveTask<Integer> {

//    private static final int THRESHOLD = 4;
private static final int THRESHOLD = 2;
    private final List<Integer> list;

    public SumTask(List<Integer> list) {
        this.list = list;
    }

    @Override
    protected Integer compute() {

        // 작업 범위가 작은면 직접 계산
        if (list.size() <= THRESHOLD) {

            MyLogger.log("처리시작 " + list);
            return list.stream().map(HeavyJob::heavyTask).reduce(0, (a, b) -> a + b);

        } else{
            // 크면 반으로 나눠서 계산
            int mid = list.size() / 2;
            List<Integer> left = list.subList(0, mid);
            List<Integer> right = list.subList(mid, list.size());
            MyLogger.log("[분할] " + left +" / " + right);

            SumTask leftTask = new SumTask(left);
            SumTask rightTask = new SumTask(right);

            ForkJoinTask<Integer> fork = leftTask.fork();
            Integer compute = rightTask.compute();

            Integer join = fork.join();
            return compute + join;

        }
    }
}
