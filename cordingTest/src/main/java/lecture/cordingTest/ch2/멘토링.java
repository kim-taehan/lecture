package lecture.cordingTest.ch2;

import java.util.Scanner;

/*
현수네 반 선생님은 반 학생들의 수학점수를 향상시키기 위해 멘토링 시스템을 만들려고 합니다.

4 3
3 4 1 2
4 3 2 1
3 1 4 2

3
 */
public class 멘토링 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int studentCnt = scanner.nextInt();
        int testCnt = scanner.nextInt();

        int[][] arr = new int[testCnt][studentCnt];
        for (int i = 0; i < testCnt; i++) {
            for (int j = 0; j < studentCnt; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }
        System.out.println(solution(studentCnt, testCnt, arr));
    }

    private static int solution(int studentCnt, int testCnt, int[][] arr) {
        int answer = 0;
        for (int i = 1; i <= studentCnt; i++) {
            for (int j = 1; j <= studentCnt; j++) {
                if (i == j) {
                    continue;
                }
                boolean cnt = getCnt(studentCnt, testCnt, arr, i, j);
                if (cnt) {
                    answer++;
                }
            }
        }
        return answer;
    }

    private static boolean getCnt(int studentCnt, int testCnt, int[][] arr, int i, int j) {
        for (int k = 0; k < testCnt; k++) {
            for (int s = 0; s < studentCnt; s++) {
                int number = arr[k][s];
                if (i == number) {
                    break;
                } else if (j == number) {
                    return false;
                }

            }
        }
        return true;
    }
}
