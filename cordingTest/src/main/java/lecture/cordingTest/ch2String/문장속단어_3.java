package lecture.cordingTest.ch2String;

import java.util.Scanner;

public class 문장속단어_3 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String input1 = scanner.nextLine();
        System.out.println(solution(input1));
    }

    private static String solution(String text) {
        String maxWord = "";
        for (String s : text.split(" ")) {
            if (maxWord.length() < s.length()) {
                maxWord = s;
            }
        }
        return maxWord;
    }


}
