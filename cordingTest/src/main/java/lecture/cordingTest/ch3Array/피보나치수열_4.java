package lecture.cordingTest.ch3Array;

import java.util.Scanner;

/**
 * 피보나치
 * input: 10
 * output: 1 1 2 3 5 8 13 21 34 55
 */
public class 피보나치수열_4 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        for (int i : solution(size)) {
            System.out.print(i+" ");
        }
    }
    public static int[] solution(int size) {
        int[] result = new int[size];
        result[1] = 1;
        result[2] = 1;
        for (int i = 3; i < size; i++) {
            result[i] = result[i - 1] + result[i - 2];
        }
        return result;
    }
}
