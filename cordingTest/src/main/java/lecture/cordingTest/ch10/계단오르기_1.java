package lecture.cordingTest.ch10;

import java.util.Scanner;

/*
철수는 계단을 오를 때 한 번에 한 계단 또는 두 계단씩 올라간다. 만약 총 4계단을 오른다면
그 방법의 수는
1+1+1+1,  1+1+2,   1+2+1,   2+1+1,   2+2 로 5가지이다.
그렇다면 총 N계단일 때 철수가 올라갈 수 있는 방법의 수는 몇 가지인가?


▣ 입력예제 1
7
▣ 출력예제 1
21
 */
public class 계단오르기_1 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int ret = solution(n);
        System.out.println(ret);


    }

    static int solution(int n) {

        int[] arr = new int[n+1];

        arr[1] = 1;
        arr[2] = 2;
        for (int i = 3; i <= n; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }

        return arr[n];
    }
}
