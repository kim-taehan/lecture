package lecture.cordingTest.ch3Array;

import java.util.Scanner;

/**
 * in:
 * 5
 * 87 89 92 100 76
 * out:
 * 4 3 2 1 5
 */
public class 등수구하기_8 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int[] input = new int[size];
        for (int i = 0; i < size; i++) {
            input[i] = scanner.nextInt();
        }
        int[] ret = solution(size, input);
        for (int i : ret) {
            System.out.print(i+" ");
        }
    }
    public static int[] solution(int size, int[] input) {

        int[] result = new int[size];
        for (int i = 0; i < size; i++) {
            int score = input[i];
            int rank = 1;
            for (int j = 0; j < size; j++) {
                if (score < input[j]) {
                    rank++;
                }
            }
            result[i] = rank;
        }
        return result;
    }
}
