package lecture.cordingTest.ch10;

import java.util.Scanner;

/*
철수는 학교에 가는데 개울을 만났습니다. 개울은 N개의 돌로 다리를 만들어 놓았습니다. 철
수는 돌 다리를 건널 때 한 번에 한 칸 또는 두 칸씩 건너뛰면서 돌다리를 건널 수 있습니다.
철수가 개울을 건너는 방법은 몇 가지일까요?


 */
public class 돌다리건너기_2 {

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

        return arr[n] + arr[n-1];
    }
}
