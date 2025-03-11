package lecture.cordingTest.ch6Sort;

import java.util.Arrays;
import java.util.Scanner;

/*

만약 N명의 학생들이 적어낸 숫자 중 중복된 숫자가 존재하면 D(duplication)를 출력하고,
N명이 모두 각자 다른 숫자를 적어냈다면 U(unique)를 출력하는 프로그램을 작성하세요.


8
20 25 52 30 39 33 43 33

D
 */
public class 중복확인_5 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        int[] array = new int[count];
        for (int i = 0; i < count; i++) {
            array[i] = scanner.nextInt();
        }

        System.out.println(solution(count, array));
    }

    private static String solution(int count, int[] array) {

        Arrays.sort(array);
        for (int i = 1; i < count; i++) {
            if(array[i] == array[i-1]) return "D";
        }
        return "U";
    }
}
