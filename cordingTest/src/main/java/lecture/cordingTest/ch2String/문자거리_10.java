package lecture.cordingTest.ch2String;

import java.util.Scanner;

/**
 * shortest text distance (가장 짧은 문자거리)
 * input : teachermode e
 * output : 1 0 1 2 1 0 1 2 2 1 0
 */
public class 문자거리_10 {


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        String[] split = text.split(" ");
        int[] word = solution(split[0], split[1].charAt(0));
        for (int i : word) {
            System.out.print(i + " ");
        }
    }

    private static int[] solution(String text, char c) {

        int[] ret = new int[text.length()];
        int p = 1000;
        for (int i = 0; i < text.length(); i++) {
            p++;
            if (text.charAt(i) == c) {
                p = 0;
            }
            ret[i] = p;
        }

        p = 1000;
        for (int i = text.length()-1; i > -1 ; i--) {
            p++;
            if (text.charAt(i) == c) {
                p = 0;
            }
            if (ret[i] > p) ret[i] = p;
        }

        return ret;
    }


}
