package lecture.cordingTest.ch5StackAndQueue;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

/*
N과 K가 주어질 때 공주를 구하러 갈 왕자의 번호를 출력하는 프로그램을 작성하시오.
8
3
 */
public class 공주구하기_6 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        System.out.println(solution(n, k));
    }

    private static int solution(int n, int k) {

        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            queue.offer(i);
        }
        while (queue.size() > 1) {
            for(int i=0; i<k-1; i++) {
                Integer poll = queue.poll();
                queue.offer(poll);
            }
            queue.poll();
        }
        return queue.poll();
    }
}
