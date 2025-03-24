package lecture.cordingTest.ch8;

import java.util.Scanner;

/*
설명
    재귀를 이용해 조합수를 구해주는 프로그램을 작성하세요.

입력
    첫째 줄에 자연수 n(3<=n<=33)과 r(0<=r<=n)이 입력됩니다.

출력
    첫째 줄에 조합수를 출력합니다

5 3
10

33 19
818809200
 */
public class 조합의경우수_7 {

    static int[][] history;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int r = scanner.nextInt();
        history = new int[n + 1][r + 1];
        int recursion = recursion(n, r);

        System.out.println(recursion);
    }

    static int recursion(int n, int r) {
        if(history[n][r] > 0) return history[n][r];
        if(r== 1) return n;
        if(n==r) return 1;
        int ret = recursion(n - 1, r - 1) + recursion(n - 1, r);
        history[n][r] = ret;
        return ret;
    }

}
