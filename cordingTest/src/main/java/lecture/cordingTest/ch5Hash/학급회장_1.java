package lecture.cordingTest.ch5Hash;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
선생님의 발표가 끝난 후 어떤 기호의 후보가 학급 회장이 되었는지 출력하는 프로그램을 작성하세요.

15
BACBACCACCBDEDE

C
 */
public class 학급회장_1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String text = scanner.next();


        System.out.println(solution(n, text));
    }

    private static char solution(int n, String text) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : text.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        char answer = 0;
        int cnt = 0;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (cnt < entry.getValue()) {
                cnt = entry.getValue();
                answer = entry.getKey();
            }
        }
        return answer;
    }


}
