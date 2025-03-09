package lecture.cordingTest.ch2String;

import java.util.Scanner;

public class 특정문자뒤집기_5 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String text = scanner.next();
        System.out.println(solution(text));
    }

    private static String solution(String text) {
        int lt = 0, rt = text.length()-1;
        char[] charArray = text.toCharArray();
        while (lt < rt) {
            char lChar = charArray[lt];
            if(!isAlpha(lChar)) {
                lt++;
                continue;
            }
            char rChar = charArray[rt];
            if(!isAlpha(rChar)) {
                rt--;
                continue;
            }

            char temp = charArray[lt];
            charArray[lt] = charArray[rt];
            charArray[rt] = temp;
            lt++;
            rt--;
        }
        return new String(charArray);
    }

    private static boolean isAlpha(char c) {
        int code = (int) c;
        return (code >= 97 && code <= 122) || (code >= 65 && code <= 90);
    }
}
