package lecture.cordingTest.ch2String;

import java.util.Scanner;

/**
 *
 */
public class 회문문자열_7 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String input1 = scanner.nextLine();
        System.out.println(solution(input1) ? "YES" : "NO");
    }
    public static boolean solution(String word) {
        String lowerCase = word.toLowerCase();
        int leftIndex = 0, rightIndex = word.length() -1;

        while (leftIndex < rightIndex) {
            if (lowerCase.charAt(leftIndex) != lowerCase.charAt(rightIndex)) {
                return false;
            }
            leftIndex++;
            rightIndex--;
        }
        return true;
    }
}
