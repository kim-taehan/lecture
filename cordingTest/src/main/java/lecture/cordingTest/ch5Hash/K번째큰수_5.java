package lecture.cordingTest.ch5Hash;

import java.util.Comparator;
import java.util.Scanner;
import java.util.TreeSet;

/*
기록한 값 중 K번째로 큰 수를 출력하는 프로그램을 작성하세요.

10 3
13 15 34 23 45 65 33 11 26 42

143
 */
public class K번째큰수_5 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        System.out.print(solution(n, k, arr));
    }

    private static int solution(int n, int index, int[] arr) {
        TreeSet<Integer> treeSet = new TreeSet<>(Comparator.reverseOrder());
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                for (int k = j+1; k < n; k++) {
                    treeSet.add( arr[i] + arr[j] + arr[k]);
                }
            }
        }

        int t=1;
        for (Integer i : treeSet) {
            if (index == t++) {
                return i;
            }
        }
        return -1;
    }

}
