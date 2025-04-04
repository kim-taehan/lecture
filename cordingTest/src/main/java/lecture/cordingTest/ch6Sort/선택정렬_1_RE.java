package lecture.cordingTest.ch6Sort;

import java.util.Scanner;

/*
해당 순서에 원소를 넣을 위치는 이미 정해져 있고, 어떤 원소를 넣을지 선택하는 알고리즘

6
13 5 11 7 23 15

5 7 11 13 15 23
 */
public class 선택정렬_1_RE {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        int[] solution = 선택정렬(arr);
        for (int i : solution) {
            System.out.print(i + " ");
        }
    }

    private static int[] 선택정렬(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int selectedIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[selectedIndex]) {
                    selectedIndex = j;
                }
            }
            if (selectedIndex != i) {
                int temp = arr[i];
                arr[i] = arr[selectedIndex];
                arr[selectedIndex] = temp;
            }
        }
        return arr;
    }
}
