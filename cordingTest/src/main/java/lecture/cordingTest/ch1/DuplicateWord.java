package lecture.cordingTest.ch1;

import java.util.LinkedHashSet;
import java.util.Scanner;

public class DuplicateWord {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String input1 = scanner.nextLine();

        String word = solution2(input1);
        System.out.println(word);
    }
    public static String solution(String word) {

        LinkedHashSet<Character> hashSet = new LinkedHashSet<>();
        for (char c : word.toCharArray()) {
            hashSet.add(c);
        }
        StringBuilder sb = new StringBuilder();
        for (Character c : hashSet) {
            sb.append(c);
        }
        return sb.toString();
    }

    public static String solution2(String word) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (i == word.indexOf(c)) {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
