package lecture.cordingTest.ch5StackAndQueue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

/*
(())
()(((()())(())()))(())
17
(((()(()()))(())()))(()())
24
 */
public class 쇠막대기_5 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String next = scanner.next();
        System.out.println(solution(next));
    }
    private static int solution(String text) {

        int answer = 0;
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if(c == '(') stack.push(c);
            else {
                stack.pop();
                if(text.charAt(i-1) == '(') answer += stack.size();
                else answer++;
            }
        }

        return answer;

    }

    private static int solutionOld(String text) {
        int answer = 0;

        Deque<Character> stack = new ArrayDeque<>();
        for (char c : text.toCharArray()) {

            if(c == '(') stack.push(c);
            else if(!stack.isEmpty()){
                int count = 1;
                if (stack.peek() == '(') {
                    stack.pop();
                    stack.push('*');
                    continue;
                }
                while (stack.pop() != '(') {
                    count++;
                }
                answer += count;
                for (int i = 0; i < count - 1; i++) {
                    stack.push('*');
                }
            }
        }
        return answer;
    }
}
