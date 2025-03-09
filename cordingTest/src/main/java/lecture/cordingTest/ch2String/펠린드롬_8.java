package lecture.cordingTest.ch2String;

import java.util.Scanner;

/**
 * 첫 번째 줄에 팰린드롬인지의 결과를 YES 또는 NO로 출력합니다.
 * input : found7, time: study; Yduts; emit, 7Dnuof
 * output : YES
 */
public class 펠린드롬_8 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String input1 = scanner.nextLine();
        System.out.println(solution(input1) ? "YES" : "NO");
    }
    public static boolean solution(String word) {
        String lowerCase = word.toUpperCase().replaceAll("[^A-Z]", "");
        int leftIndex = 0, rightIndex = lowerCase.length() -1;

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
