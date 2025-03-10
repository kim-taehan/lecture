package lecture.cordingTest.ch5StackAndQueue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

/*
입력된 문자열에서 소괄호 ( ) 사이에 존재하는 모든 문자를 제거하고 남은 문자만 출력하는 프로그램을 작성하세요.

(A(BC)D)EF(G(H)(IJ)K)LM(N)

EFLM
 */
public class 괄호문자제거_2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.next();


        System.out.println(solution(text));
    }

    public static String solution(String text) {

        Deque<Character> deque = new ArrayDeque<>();
        for (char c : text.toCharArray()) {
            if(c == '(') deque.push(c);
            else if(c == ')') {
                while(deque.pop() != '('){
                    ;
                }
            }
            else {
                deque.push(c);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!deque.isEmpty()) {
            sb.append(deque.pollLast());
        }
        return sb.toString();
    }
}
