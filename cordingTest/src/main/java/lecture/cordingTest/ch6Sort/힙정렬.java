package lecture.cordingTest.ch6Sort;

import java.util.Scanner;

public class 힙정렬 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        sort(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
    public static void sort(int[] arr) {
        int n = arr.length;

        // 1. 배열을 최대 힙으로 만든다
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);

        // 2. 힙에서 요소를 하나씩 꺼내어 정렬
        for (int i = n - 1; i > 0; i--) {
            // 현재 루트(최대값)를 끝으로 보낸다
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // 줄어든 힙에서 다시 최대 힙 구성
            heapify(arr, i, 0);
        }
    }

    // 힙을 유지하는 함수
    static void heapify(int[] arr, int n, int i) {
        int largest = i;        // 루트를 가장 큰 값으로 초기화
        int left = 2 * i + 1;    // 왼쪽 자식
        int right = 2 * i + 2;   // 오른쪽 자식

        // 왼쪽 자식이 루트보다 크면 largest 업데이트
        if (left < n && arr[left] > arr[largest])
            largest = left;

        // 오른쪽 자식이 largest보다 크면 largest 업데이트
        if (right < n && arr[right] > arr[largest])
            largest = right;

        // largest가 루트가 아니면 교환
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // 교환한 자식 노드를 기준으로 다시 heapify
            heapify(arr, n, largest);
        }
    }
}
