package lecture.cordingTest.ch5StackAndQueue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

/*
만약 3*(5+2)-9 을 후위연산식으로 표현하면 352+*9- 로 표현되며 그 결과는 12입니다.

352+*9-
12

573*+5-323*++
30

63
 */
public class 후위식_연산_4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String next = scanner.next();
        System.out.println(solution(next));
    }

    private static int solution(String text) {

        Deque<Integer> stack = new ArrayDeque<>();
        for (char c : text.toCharArray()) {
            // 352+*9-
            if(Character.isDigit(c)) stack.push(c-48);
            else {
                int rt = stack.pop();
                int lt = stack.pop();
                if(c == '-') stack.push(lt-rt);
                else if(c == '+') stack.push(lt+rt);
                else if(c == '*') stack.push(lt*rt);
                else if(c == '/') stack.push(lt/rt);
            }
        }
        return stack.getFirst();
    }
}
