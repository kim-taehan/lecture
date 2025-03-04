package lecture.cordingTest.ch1;

import java.util.Scanner;

/**
 * 문자열 압축
 * input: KKHSSSSSSSE
 * output: K2HS7E
 */
public class CompressionString {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String input1 = scanner.nextLine();
        System.out.println(solution(input1));
    }
    public static String solution(String word) {
        StringBuilder result = new StringBuilder();

        char prefixC = word.charAt(0);
        int compression = 0;
        for (char c : word.toCharArray()) {
            if (c == prefixC) {
                compression++;
                continue;
            }
            addData(result, prefixC, compression);
            prefixC = c;
            compression = 1;
        }
        addData(result, prefixC, compression);
        return result.toString();
    }

    private static void addData(StringBuilder result, char prefixC, int compression) {
        result.append(prefixC);
        if (compression > 1) {
            result.append(compression);
        }
    }
}
