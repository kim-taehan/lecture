package lecture.cordingTest.ch2String;

import java.util.Scanner;

public class 단어뒤집기_4 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        String[] str = new String[n];
        for (int i = 0; i < n; i++) {
            str[i] = scanner.next();
        }

        for (String x : solutionByChar(str)) {
            System.out.println(x);
        }
    }

    private static String[] solutionBySb(String[] text) {
        String[] result = new String[text.length];
        for (int i = 0; i < text.length; i++) {
            result[i] = new StringBuilder(text[i]).reverse().toString();
        }
        return result;
    }

    private static String[] solutionByChar(String[] text) {
        String[] result = new String[text.length];
        for (int i = 0; i < text.length; i++) {
            char[] charArray = text[i].toCharArray();
            int halfSize = charArray.length / 2;
            for (int j = 0; j < halfSize; j++) {
                int lastIndex = charArray.length - 1 - j;
                char temp = charArray[j];
                charArray[j] = charArray[lastIndex];
                charArray[lastIndex] = temp;
            }
            result[i] = new String(charArray);

        }
        return result;
    }


}
