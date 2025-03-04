package lecture.cordingTest.ch1;

import java.util.Scanner;

public class UpperLower {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input1 = scanner.next();
        String word = upperLower(input1);
        System.out.println(word);
    }

    static String upperLower(String text) {

        StringBuilder sb = new StringBuilder();
        for (char c : text.toCharArray()) {
            sb.append(Character.isLowerCase(c) ?
                    Character.toUpperCase(c):
                    Character.toLowerCase(c)
            );
        }
        return sb.toString();
    }
}
