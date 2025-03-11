package lecture.cordingTest.ch6Sort;

import java.util.Scanner;

/*
서로 인접한 두 원소를 검사하여 정렬하는 알고리즘

6
13 5 11 7 23 15

5 7 11 13 15 23
 */
public class 버블정렬_2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        int[] solution = solution(n, arr);
        for (int i : solution) {
            System.out.print(i + " ");
        }
    }

    private static int[] solution(int n, int[] arr) {
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n-i-1; j++) {
                if (arr[j] > arr[j+1]) {
                    int temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }
}
