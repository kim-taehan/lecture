package lecture.cordingTest.ch6Sort;

import java.util.Scanner;

/*
캐시의 크기가 주어지고, 캐시가 비어있는 상태에서 N개의 작업을 CPU가 차례로 처리한다면 N개의 작업을 처리한 후
캐시메모리의 상태를 가장 최근 사용된 작업부터 차례대로 출력하는 프로그램을 작성하세요.

5 9
1 2 3 2 6 2 3 5 7

7 5 3 2 6
 */
public class LeastRecentlyUsed_4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = scanner.nextInt();
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        int[] solution = solution(size, arr);
        for (int i : solution) {
            System.out.print(i + " ");
        }
    }

    private static int[] solution(int size, int[] arr) {
        int[] cache = new int[size];
        for (int item : arr) {
            int hitIndex = -1;
            for (int i = 0; i < size; i++) {
                if(cache[i] == item) {
                    hitIndex = i;
                    break;
                }
            }
            // miss
            if (hitIndex == -1) {
                for (int i = size-1; i > 0; i--) {
                    cache[i] = cache[i - 1];
                }
            }

            // hit
            else {
                for (int i = hitIndex; i > 0; i--) {
                    cache[i] = cache[i - 1];
                }
            }
            cache[0] = item;
        }
        return cache;
    }
}
