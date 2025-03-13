package lecture.cordingTest.ch7;

import java.util.Scanner;

/*
10진수 N이 입력되면 2진수로 변환하여 출력하는 프로그램

11
1011
 */
public class 이진수출력_2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        String  result = recursive(n);
        System.out.println(result);
    }

    private static String recursive(int n) {

        if(n > 1) {
            String recursive = recursive(n / 2);
            return recursive + (n % 2);
        }
        return n+"";

    }
}
