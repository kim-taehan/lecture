package lecture.cordingTest.ch3Array;

import java.util.Scanner;

/*
9. 격자판 최대합

input :
5
10 13 10 12 15
12 39 30 23 11
11 25 50 53 15
19 27 29 37 27
19 13 30 13 19

output:
155

 */
public class 격자판_최대합_9 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();

        int[][] ints = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                ints[i][j] = scanner.nextInt();
            }
        }
        System.out.println(solution(size, ints));
    }

    private static int solution(int size, int[][] ints) {

        int maxValue = 0;
        int sum1, sum2;
        for (int i = 0; i < size; i++) {
            sum1 = sum2 = 0;
            for (int j = 0; j < size; j++) {
               sum1 += ints[i][j];
               sum2 += ints[j][i];
            }
            maxValue = Math.max(maxValue, sum1);
            maxValue = Math.max(maxValue, sum2);
        }

        sum1 = sum2 = 0;
        for (int i = 0; i < size; i++) {
            sum1 += ints[i][i];
            sum2 += ints[i][size - i - 1];
        }
        maxValue = Math.max(maxValue, sum1);
        maxValue = Math.max(maxValue, sum2);

        return maxValue;
    }
}
