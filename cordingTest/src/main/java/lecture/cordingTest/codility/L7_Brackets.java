package lecture.cordingTest.codility;

import java.util.ArrayDeque;
import java.util.Map;

public class L7_Brackets {

    private static final Map<Character, Character> characters = Map.of(
            ']', '['
            , '}', '{'
            , ')', '(');

    public int solution(String S){

        if (S.length() % 2 == 1) {
            return 0;
        }

        ArrayDeque<Character> stack = new ArrayDeque<>();

        for (char c : S.toCharArray()) {
            if (characters.containsKey(c)) { // 닫는 괄호일 경우
                if (stack.isEmpty() || !stack.removeLast().equals(characters.get(c))) {
                    return 0;
                }
            } else { // 여는 괄호일 경우
                stack.addLast(c);
            }
        }
        return 1;
    }
}
