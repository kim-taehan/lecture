package lecture.cordingTest.ch2;

import java.util.Scanner;

/*
봉우리: 각 격자판의 숫자 중 자신의 상하좌우 숫자보다 큰 숫자는 봉우리 지역입니다. 봉우리 지역이 몇 개 있는 지 알아내는 프로그램을 작성하세요.
input:
5
5 3 7 2 3
3 7 1 6 1
7 2 5 3 4
4 3 6 4 1
8 7 3 5 2
output:
10
 */
public class 봉우리 {

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

        int count = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                int value = ints[i][j];
                if (i > 0 && value <= ints[i - 1][j]) {
                    continue;
                }
                if (i != (size-1) && value <= ints[i + 1][j]) {
                    continue;
                }
                if (j > 0 && value <= ints[i][j-1]) {
                    continue;
                }
                if (j != (size-1) && value <= ints[i][j+1]) {
                    continue;
                }
                count++;
            }
        }
        return count;
    }
}
