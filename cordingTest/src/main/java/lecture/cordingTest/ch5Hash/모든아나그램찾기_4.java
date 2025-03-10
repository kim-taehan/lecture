package lecture.cordingTest.ch5Hash;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

/*
S문자열에서 T문자열과 아나그램이 되는 S의 부분문자열의 개수를 구하는 프로그램을 작성하세요.

bacaAacba
abc

3
 */
public class 모든아나그램찾기_4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text1 = scanner.nextLine();
        String text2 = scanner.next();


        System.out.println(solution(text1, text2));
    }

    private static int solution(String sentence, String word) {
        int answer = 0;

        Map<Character, Integer> wordMap = new HashMap<>();
        for (char c : word.toCharArray()) {
            wordMap.put(c, wordMap.getOrDefault(c, 0) + 1);
        }

        Map<Character, Integer> sentencedMap = new HashMap<>();
        char[] charArray = sentence.toCharArray();
        int i = 0;
        int length = word.length();
        for (; i < length-1; i++) {
            sentencedMap.put(charArray[i], sentencedMap.getOrDefault(charArray[i], 0) + 1);
        }
        for (; i < sentence.length(); i++) {
            sentencedMap.put(charArray[i], sentencedMap.getOrDefault(charArray[i], 0) + 1);
            // check
            if(isEqual(sentencedMap, wordMap)){
                answer++;
            }
            char removeC = charArray[i - length+1];
            sentencedMap.put(removeC, sentencedMap.get(removeC) -1);
        }
        return answer;
    }

    private static boolean isEqual(Map<Character, Integer> sentencedMap, Map<Character, Integer> wordMap) {
        for (Character c : wordMap.keySet()) {
            if (!Objects.equals(wordMap.get(c), sentencedMap.getOrDefault(c, 0))) {
                return false;
            }
        }
        return true;
    }
}
