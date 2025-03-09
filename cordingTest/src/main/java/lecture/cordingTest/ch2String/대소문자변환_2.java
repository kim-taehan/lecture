package lecture.cordingTest.ch2String;

import java.util.Scanner;

public class 대소문자변환_2 {
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
