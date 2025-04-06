package lecture.cordingTest.ch6결정알고리즘;

import java.util.Scanner;

/*
너는 K개의 랜선을 가지고 있어. 이걸 잘라서 N개 이상의 랜선을 만들어야 해. 최대한 긴 랜선을 만들고 싶어.


4 11
802
743
457
539

200
 */
public class 가장긴랜선만들기 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int K = sc.nextInt();
        int N = sc.nextInt();
        int[] arr = new int[K];

        int max = 0;
        for (int i = 0; i < K; i++) {
            arr[i] = sc.nextInt();
            max = Math.max(max, arr[i]);
        }

        int low = 1;
        int high = max;
        int answer = 0;


        int solution = solution(low, high, arr, N);
        System.out.println(solution);
    }

    private static int solution(int low, int high, int[] arr, int N) {
        int answer = 0;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (count(arr, mid) >= N) {
                answer = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return answer;
    }

    private static int count(int[] arr, int mid) {
        int count = 0;
        for (int line : arr) {
            count += line / mid;
        }
        return count;
    }

}
