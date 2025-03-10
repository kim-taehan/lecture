package lecture.cordingTest.ch4TwoPointers;

import java.util.Scanner;

/*
N입력으로 양의 정수 N이 입력되면 2개 이상의 연속된 자연수의 합으로 정수 N을 표현하는 방법의 가짓수를 출력하는 프로그램을 작성하세요.

15

3

19
1

120
3
 */
public class 연속된자연수합_5 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();


        System.out.println(solution2(n));
    }

    private static int solution(int n) {
        int answer = 0, lt = 1, sum = 0;
        for (int rt = 1; rt <= n/2+1; rt++) {
            sum += rt;
            if (sum == n) {
                answer++;
            }
            while (sum >= n) {
                sum -= lt++;
                if (sum == n) {
                    answer++;
                }
            }
        }
        return answer;
    }

    /**
     * 수학적으로 해결하는 방법
     */
    private static int solution2(int n) {

        int answer = 0;

        for(int i =2; i<n/2; i++) {
            int sum = 0;
            for (int j = 1; j <= i; j++) sum += j;
            if (n-sum >= 0 && (n-sum) % i == 0) answer++;
        }

        return answer;
    }
}
