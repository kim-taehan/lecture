package lecture.cordingTest.ch10;

import java.util.Scanner;

import static lecture.cordingTest.ch3Array.보이는학생2.solution;

/*
N개의 자연수로 이루어진 수열이 주어졌을 때, 그 중에서 가장 길게 증가하는(작은 수에서 큰
수로) 원소들의 집합을 찾는 프로그램을 작성하라. 예를 들어, 원소가 2, 7, 5, 8, 6, 4, 7,
12, 3 이면 가장 길게 증가하도록 원소들을 차례대로 뽑아내면 2, 5, 6, 7, 12를 뽑아내어 길
이가 5인 최대 부분 증가수열을 만들 수 있다

 ▣ 입력예제 1
8
5 3 7 8 6 2 9 4

▣ 출력예제 1
4


70
39 68 2 31 3 56 25 58 57 35 63 19 69 22 54 38 41 53 6 32 27 34 17 61 8 36 18 55 26 66 43 24 12 50 30 59 47 46 33 70 4 21 10 44 62 28 65 14 37 15 45 48 7 64 1 49 51 13 23 60 20 40 11 5 67 16 9 29 52 42

15
 */
public class 최대부분증가수열_3 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        int ret = solution(arr);
        System.out.println(ret);

    }

    static int solution(int[] arr) {
        int dy[] = new int[arr.length];
        int max = dy[0]  = 1;
        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (arr[i] > arr[j]) {
                    dy[i] = Math.max(dy[j] + 1, dy[i]);
                    int tempMax = max;
                    max = Math.max(dy[i], max);
                    if (dy[j] == tempMax) break;
                }
            }

            if (dy[i] == 0) {
                dy[i] = 1;
            }
        }
        return max;
    }

}
