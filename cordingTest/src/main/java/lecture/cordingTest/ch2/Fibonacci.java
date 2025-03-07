package lecture.cordingTest.ch2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 피보나치
 * input: 10
 * output: 1 1 2 3 5 8 13 21 34 55
 */
public class Fibonacci {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        for (int i : solution(size)) {
            System.out.print(i+" ");
        }
    }
    public static int[] solution(int size) {
        int[] result = new int[size];
        result[0] = 1;
        result[1] = 1;
        for (int i = 2; i < size; i++) {
            result[i] = result[i - 1] + result[i - 2];
        }
        return result;
    }
}
