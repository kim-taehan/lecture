package lecture.cordingTest.ch3Array;

import java.util.Scanner;

/**
 * 보이는 학생
 * input : 8
 *         130 135 148 140 145 150 150 153
 * output : 5
 */
public class 보이는학생2 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int[] input = new int[size];
        for (int i = 0; i < size; i++) {
            input[i] = scanner.nextInt();
        }
        System.out.print(solution(input));
    }
    public static int solution(int[] input) {
        int biggestLength = 0;
        int result = 0;
        for (int length : input) {
            if (length > biggestLength) {
                result++;
                biggestLength = length;
            }
        }
        return result;
    }
}
