package lecture.cordingTest.ch6Sort;

import java.util.Scanner;
/*

11
13 5 11 7 23 15 1 25 4 7 21

5 7 11 13 15 23
 */
public class 쉘정렬 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        int[] solution = 쉘정렬(arr);
        for (int i : solution) {
            System.out.print(i + " ");
        }
    }

    static int[] 쉘정렬(int[] arr) {
        int n = arr.length;

        // 초기 gap 설정 (보통 n/2부터 시작해서 1까지 감소)
        for (int gap = n / 2; gap > 0; gap /= 2) {

            // gap 만큼 떨어진 요소들끼리 삽입 정렬 수행
            for (int i = gap; i < n; i++) {
                int temp = arr[i];
                int j;

                for (j = i; j >= gap && arr[j - gap] > temp; j -= gap) {
                    arr[j] = arr[j - gap];
                }

                arr[j] = temp;
            }
        }
        return arr;
    }
}
