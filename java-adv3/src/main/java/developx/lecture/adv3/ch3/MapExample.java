package developx.lecture.adv3.ch3;

import java.util.List;

public class MapExample {

    public static List<String> map(List<String> list, StringFunction func) {

        return list.stream().map(s -> func.apply(s)).toList();
    }

    public static void main(String[] args) {
        List<String> words = List.of("hello", "java", "lambda");
        System.out.println("원본 리스트: " + words);

        // 1. 대문자 변환
        // 코드 작성
        List<String> 대문자 = map(words, s -> s.toUpperCase());
        System.out.println("대문자 = " + 대문자);
        // 2. 앞뒤에 *** 붙이기 (람다로 작성)
        // 코드 작성
        List<String> prefixWord = map(words, s -> "***" + s);
        System.out.println("prefixWord = " + prefixWord);
    }

}
