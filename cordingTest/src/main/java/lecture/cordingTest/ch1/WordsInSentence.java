package lecture.cordingTest.ch1;

import java.util.Scanner;

public class WordsInSentence {

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
