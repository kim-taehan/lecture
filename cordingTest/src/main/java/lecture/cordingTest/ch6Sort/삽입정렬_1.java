package lecture.cordingTest.ch6Sort;

import java.util.Scanner;

/*
6
11 7 5 6 10 9

5 6 7 9 10 11
 */
public class 삽입정렬_1 {

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
        for (int i = 1; i < n; i++) {
            int temp = arr[i];
            int j = i-1;
            for (; j >= 0; j--) {
                if (arr[j] > temp) {
                    arr[j+1] = arr[j];
                } else break;
            }
            arr[j+1] = temp;
        }
        return arr;
    }
}
