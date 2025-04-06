package lecture.cordingTest.ch6Sort;

import java.util.Scanner;

public class 합병정렬 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        sort(arr, 0, arr.length-1);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    public static void sort(int arr[], int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;

            // 왼쪽 반 정렬
            sort(arr, left, mid);
            // 오른쪽 반 정렬
            sort(arr, mid + 1, right);

            // 두 개를 병합
            merge(arr, left, mid, right);
        }
    }

    // 두 개의 배열을 병합하는 함수
    private static void merge(int arr[], int left, int mid, int right) {
        // 왼쪽, 오른쪽 길이
        int n1 = mid - left + 1;
        int n2 = right - mid;

        // 임시 배열 생성
        int L[] = new int[n1];
        int R[] = new int[n2];

        // 데이터 복사
        for (int i = 0; i < n1; i++)
            L[i] = arr[left + i];
        for (int j = 0; j < n2; j++)
            R[j] = arr[mid + 1 + j];

        // 병합
        int i = 0, j = 0;
        int k = left;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        // 남은 데이터 복사
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
}
