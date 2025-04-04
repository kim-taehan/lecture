package lecture.cordingTest.ch6Sort;

import java.util.Scanner;

/*

11
13 5 11 7 23 15 1 25 4 7 21
 */
public class 퀵정렬 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        quickSort(arr, 0, arr.length-1);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            // 분할 위치를 기준으로 정렬
            int pivotIndex = partition(arr, low, high);

            quickSort(arr, low, pivotIndex - 1);   // 왼쪽 부분 정렬
            quickSort(arr, pivotIndex + 1, high);  // 오른쪽 부분 정렬
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high]; // 마지막 요소를 피벗으로 선택
        int i = low - 1;       // 작은 요소들의 끝 인덱스

        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                swap(arr, ++i, j); // 작거나 같은 요소를 왼쪽으로 이동
            }
        }

        swap(arr, i + 1, high); // 피벗을 중앙으로 이동
        return i + 1;           // 피벗의 인덱스 반환
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
