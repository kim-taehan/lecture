package lecture.cordingTest.ch4TwoPointers;

import java.util.Scanner;

/*
N개의 수로 이루어진 수열이 주어집니다.
이 수열에서 연속부분수열의 합이 특정숫자 M이 되는 경우가 몇 번 있는지 구하는 프로그램을 작성하세요.

8 6
1 2 1 3 1 1 1 2

3


100 100
3 3 1 4 5 2 2 5 2 1 2 2 1 1 4 1 4 3 3 5 1 5 1 3 4 5 4 5 2 4 2 1 1 4 2 1 5 3 1 3 1 1 1 2 4 4 5 5 5 5 3 2 5 5 3 2 3 4 1 3 3 4 5 1 3 1 3 2 3 1 2 3 2 5 5 4 2 3 1 2 3 2 4 5 2 4 4 4 4 3 1 5 2 2 1 3 2 5 4 1

23
: 슬라이딩 윈도우의 변형 문제로 박스의 크기가 가변적으로 변경된는 점만 유의 하자

 */
public class 연속부분수열_4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        System.out.println(solution2(n, k, arr));
    }


    private static int solution2(int n, int m, int[] arr) {
        int answer = 0, sum=0, lt=0;
        for (int rt = 0; rt < n; rt++) {
            sum+=arr[rt];
            if(sum == m) answer++;
            while (sum >= m) {
                sum -= arr[lt++];
                if(sum == m) answer++;
            }
        }
        return answer;
    }
    private static int solution(int n, int k, int[] arr) {
        int answer = 0;
        int index = 0;
        int doSum = 0;

        for (int i = 0; i < n; i++) {
            doSum+=arr[i];
            if (doSum == k) {
                answer++;
                doSum -= arr[index++];
            }
            while (doSum > k && index < n-1) {
                doSum -= arr[index++];
                if (doSum == k) {
                    answer++;
                    doSum -= arr[index++];
                    break;
                }
            }
        }
        return answer;
    }
}
