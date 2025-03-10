package lecture.cordingTest.ch5Hash;

import java.util.HashMap;
import java.util.Scanner;

/*
7 4
20 12 20 10 23 17 10

3 4 4 3
 */
public class 매출액종류_3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        int[] solution = solution(n, k, arr);
        for (int i : solution) {
            System.out.print(i+" ");
        }

    }

    private static int[] solution(int n, int k, int[] arr) {

        int[] answer = new int[n - k + 1];
        HashMap<Integer, Integer> map = new HashMap<>();
        int i = 0;
        for (; i < k-1; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
        }
        int index = 0;
        for (; i < n; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
            answer[index++] = map.keySet().size();
            int key = arr[i - k + 1];
            Integer size = map.get(key);
            if (size == 1) {
                map.remove(key);
            }
            else {
                map.put(key, map.get(key)-1);
            }
        }
        return answer;
    }
}
