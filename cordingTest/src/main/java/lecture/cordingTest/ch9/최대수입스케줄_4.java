package lecture.cordingTest.ch9;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

/*
각 기업이 요청한 D와 M를 바탕으로 가장 많을 돈을 벌 수 있도록 강연 스케쥴을 짜야 한다.
단 강연의 특성상 현수는 하루에 하나의 기업에서만 강연을 할 수 있다.
 ▣입력설명
첫 번째 줄에 자연수 N(1<=N<=10,000)이 주어지고, 다음 N개의 줄에 M(1<=M<=10,000)과
D(1<=D<=10,000)가 차례로 주어진다.
 ▣출력설명
첫 번째 줄에 최대로 벌 수 있는 수입을 출력한다.
 ▣입력예제 1
6
50 2
20 1
40 2
60 3
30 3
30 1

▣출력예제 1
150
 */
public class 최대수입스케줄_4 {

    static class Lecture implements Comparable<Lecture> {
        int fee;
        int day;

        public Lecture(int fee, int day) {
            this.fee = fee;
            this.day = day;
        }


        @Override
        public int compareTo(Lecture o) {
            return o.day - this.day;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Lecture[] lectures = new Lecture[n];
        for (int i = 0; i < lectures.length; i++) {
            lectures[i] = new Lecture(scanner.nextInt(), scanner.nextInt());
        }

        int ret = solution(lectures);
        System.out.println(ret);
    }

    private static int solution(Lecture[] lectures) {
        int totalFee = 0;
        Arrays.sort(lectures);

        int maxDay = lectures[0].day;
        Queue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);

        int i = 0;
        for (int day = maxDay; day > 0; day--) {
            for (; i < lectures.length; i++) {
                Lecture lecture = lectures[i];
                if(lecture.day < day) break;
                queue.add(lecture.fee);
            }
            if(!queue.isEmpty()) totalFee += queue.poll();
        }
        return totalFee ;
    }
}
