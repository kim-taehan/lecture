package lecture.cordingTest.ch3Array;

import java.util.Scanner;

/*
5
2 3 1 7 3
4 1 9 6 8
5 5 2 4 4
6 5 2 6 7
8 4 2 2 2

4
 */
public class 임시반장_정하기_11 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();

        int[][] ints = new int[size][5];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < 5; j++) {
                ints[i][j] = scanner.nextInt();
            }
        }
        System.out.println(solution(size, ints));
    }

    private static int solution(int size, int[][] arr) {
        int answer = 0;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < size; i++) {
            int count = 0;
            for (int j = 0; j < size; j++) {
                for (int k = 0; k < 5; k++) {
                    if (arr[i][k] == arr[j][k]) {
                        count++;
                        break;
                    }
                }
            }
            if (max < count) {
                answer = i;
                max = count;
            }
        }
        return answer + 1;
    }
}
