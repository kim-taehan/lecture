package lecture.cordingTest.ch1;

import java.util.Scanner;

/**
 * 암호
 * input : 4
 *         #****###**#####**#####**##**
 * output : COOL
 */
public class Password {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String next = scanner.next();
        System.out.println(solution(n, next));
    }

    private static String solution(int n, String next) {
        StringBuilder sb = new StringBuilder();

        next = next.replaceAll("#", "1").replaceAll("\\*", "0");
        for (int i = 0; i < n; i++) {
            int start = i * 7;
            int end = start + 7;
            String text = next.substring(start, end);
            sb.append((char) Integer.parseInt(text, 2));
        }
        return sb.toString();
    }
}
