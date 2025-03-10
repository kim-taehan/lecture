package lecture.cordingTest.ch5Hash;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
아나그램 : 길이가 같은 두 개의 단어가 주어지면 두 단어가 아나그램인지 판별하는 프로그램을 작성하세요. 아나그램 판별시 대소문자가 구분됩니다.

AbaAeCe
baeeACA

YES

abaCC
Caaab

NO
 */
public class 아나그램 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text1 = scanner.nextLine();
        String text2 = scanner.next();


        System.out.println(solution(text1, text2));
    }

    private static String solution(String text1, String text2) {

        Map<Character, Integer> map = new HashMap<>();
        for (char c : text1.toCharArray())
            map.put(c, map.getOrDefault(c, 0) + 1);

        for (char c : text2.toCharArray()){
            if(!map.containsKey(c) || map.get(c) == 0) return "NO";
            map.put(c, map.get(c) - 1);
        }

        return "YES";
    }
}
