package lecture.cordingTest.ch6결정알고리즘;

import java.util.Arrays;
import java.util.Scanner;

/*
9 3
1 2 3 4 5 6 7 8 9

17


5 4
1 1 1 1 1


2
 */
public class 뮤직비디오_9 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = scanner.nextInt();
        int count = scanner.nextInt();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = scanner.nextInt();
        }
        int solution = solution(size, count, arr);
        System.out.print(solution);

    }


    private static int solution(int size, int count, int[] arr) {
        int answer = 0;
        int rt = Arrays.stream(arr).sum();
        int lt = Arrays.stream(arr).max().getAsInt();
        while (lt <= rt) {
            int mid = (lt + rt) / 2;
            if (divide(arr, mid) <= count) {
                answer = mid;
                rt = mid - 1;
            } else {
                lt = mid + 1;
            }
        }
        return answer;
    }

    private static int divide(int[] arr, int mid) {
        int count = 1;
        int sum = 0;
        for (int i : arr) {
            sum += i;
            if (mid < sum) {
                sum = i;
                count++;
            }
        }
        return count;
    }
}
