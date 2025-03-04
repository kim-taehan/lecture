package lecture.cordingTest.ch1;

import java.util.Scanner;

/**
 * 숫자만 출력
 * input: g0en2T0s8eSoft
 * output: 208
 */
public class ExtractNumbers {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String input1 = scanner.nextLine();
        System.out.println(solution(input1));
    }
    public static int solution(String word) {

        int result = 0;
        for (char c : word.toCharArray()) {
            int number = c;
            if (number >= 48 && number <= 57) {
                result = result * 10 + (number - 48);
            }
        }
        return result;
    }
}
