package lecture.cordingTest.ch8;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

/*
설명
    다음과 같이 여러 단위의 동전들이 주어져 있을때 거스름돈을 가장 적은 수의 동전으로 교환해주려면 어떻게 주면 되는가?
    각 단위의 동전은 무한정 쓸 수 있다.

입력
    첫 번째 줄에는 동전의 종류개수 N(1<=N<=12)이 주어진다. 두 번째 줄에는 N개의 동전의 종류가 주어지고,
    그 다음줄에 거슬러 줄 금액 M(1<=M<=500)이 주어진다.각 동전의 종류는 100원을 넘지 않는다.

출력
    첫 번째 줄에 거슬러 줄 동전의 최소개수를 출력한다

3
1 2 5
15

3
 */
public class 동전교환_4 {

    private static int N, M;
    private static int[] coins;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        coins = new int[N];
        for (int i = 0; i < N; i++) {
            coins[i] = scanner.nextInt();
        }
        M = scanner.nextInt();
        System.out.println(bfs());
    }

    static int bfs() {
        Queue<Integer> arrayDeque = new ArrayDeque<>();
        int level = 0;
        for (int coin : coins) {
            arrayDeque.add(coin);
        }

        while (!arrayDeque.isEmpty()) {
            level++;
            int len = arrayDeque.size();
            for (int i = 0; i < len; i++) {
                Integer item = arrayDeque.poll();
                if (item == M) return level;
                for (int coin : coins) {
                    arrayDeque.add(item + coin);
                }
            }
        }
        return 0;
    }
}
