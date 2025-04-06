package lecture.cordingTest.ch6결정알고리즘;

import java.util.Arrays;
import java.util.Scanner;

/*
한 마을에 떡볶이 떡 가게가 있다.
떡의 길이가 다 다르고, 손님이 "적어도 M만큼의 떡을 가져가고 싶다"라고 요구했다.

첫째 줄에 떡의 개수 N과 요청한 떡의 길이 M이 주어진다. (1 ≤ N ≤ 1,000,000, 1 ≤ M ≤ 2,000,000,000)
둘째 줄에 떡의 개별 높이가 주어진다. (0 ≤ 높이 ≤ 1,000,000,000)

4 6
19 15 10 17

15

 */
public class 떡뽁기만들기 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        int high = Arrays.stream(arr).max().getAsInt();
        int low = 1;
        int answer = 0;

        while (low <= high) {
            int mid = (high + low) / 2 ;

            if (count(arr, mid) >= m) {
                answer = mid;
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        System.out.println(answer);
    }

    private static int count(int[] arr, int mid) {
        int length = 0;
        for (int i : arr) {
            length += (i > mid) ? i - mid : 0;
        }
        return length;
    }
}
