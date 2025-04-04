package lecture.cordingTest.ch3Array;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 뒤집은 소수
 * input: 9
 *        32 55 62 20 250 370 200 30 100
 * output: 23 2 73 2 3
 */
public class 뒤집은소수_6 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int[] inputs = new int[size];
        for (int i = 0; i < size; i++) {
            inputs[i] = scanner.nextInt();
        }
        List<Integer> result = solution(size, inputs);
        for (Integer i : result) {
            System.out.print(i+" " );
        }
    }

    private static List<Integer> solution(int size, int[] inputs) {

        List<Integer> result = new ArrayList<>();

        for (int input : inputs) {
            int reverseNumber = 0;
            while (input > 0) {
                reverseNumber = reverseNumber * 10 + (input % 10);
                input = input / 10;
            }
            if (isPrime(reverseNumber)) {
                result.add(reverseNumber);
            }
        }


        return result;
    }

    private static boolean isPrime(int number) {
        if (number < 2) {
            return false;
        }

        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

}
