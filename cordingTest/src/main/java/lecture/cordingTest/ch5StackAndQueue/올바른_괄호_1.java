package lecture.cordingTest.ch5StackAndQueue;


import java.util.*;

/*
(()(()))(()

NO


(())()

YES
 */
public class 올바른_괄호_1 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String text = scanner.next();


        System.out.println(solution(text));
    }

    public static String solution(String text) {

        Deque<Character> deque = new ArrayDeque<>();
        for (char c : text.toCharArray()) {
            if(c == '(') {
                deque.push(c);
            }
            else {
                if (deque.isEmpty()) {
                    return "NO";
                }
                deque.pop();
            }
        }
        return deque.isEmpty() ? "YES" : "NO";
    }
}
