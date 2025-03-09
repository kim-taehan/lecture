package lecture.cordingTest.ch2String;

import java.util.Scanner;

public class 문자찾기_1 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String input1 = scanner.next().toLowerCase();
        char input2 = scanner.next().toLowerCase().charAt(0);

        int word = findWord(input1, input2);
        System.out.println(word);
    }
    public static int findWord(String word, char c) {
        int result = 0;
        for (char c1 : word.toCharArray()) {
            if (c == c1) {
                result++;
            }
        }
        return result;
    }

}
