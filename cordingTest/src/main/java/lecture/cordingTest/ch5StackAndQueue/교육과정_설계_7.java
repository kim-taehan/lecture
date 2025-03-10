package lecture.cordingTest.ch5StackAndQueue;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

/*
CBA
CBDAGE

YES


ZA
CBDAGE
 */
public class 교육과정_설계_7 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text1 = scanner.next();
        String text2 = scanner.next();

        System.out.println(solution(text1, text2));
    }

    private static String solution(String text1, String text2) {

        Queue<Character> queue = new ArrayDeque<>();
        for (char c : text1.toCharArray()) {
            queue.offer(c);
        }

        for (int i = 0; i < text2.length(); i++) {
            char c = text2.charAt(i);
            if (queue.contains(c)) {
                if(c != queue.poll()) return "NO";
            }
        }
        return queue.isEmpty() ? "YES" : "NO";
    }
}
