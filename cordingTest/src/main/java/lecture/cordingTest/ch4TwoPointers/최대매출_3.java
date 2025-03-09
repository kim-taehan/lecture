package lecture.cordingTest.ch4TwoPointers;

import java.util.Scanner;

/*
N일 동안의 매출기록을 주고 연속된 K일 동안의 최대 매출액이 얼마인지 구하라고 했습니다.

10 3
12 15 11 20 25 10 20 19 13 15

56
 */
public class 최대매출_3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        System.out.println(solution(n, m, arr));
    }

    private static int solution(int n, int m, int[] arr) {

        int doSum = 0;
        for (int i = 0; i < m; i++) {
            doSum += arr[i];
        }
        int maxAmount = doSum;

        for (int i = m; i < n; i++) {
            doSum = doSum + arr[i] - arr[i - m];
            maxAmount = Math.max(doSum, maxAmount);
        }
        return maxAmount;
    }


}
