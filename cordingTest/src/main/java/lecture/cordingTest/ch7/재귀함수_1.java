package lecture.cordingTest.ch7;

import java.util.Scanner;

/*
자연수 N이 입력되면 재귀함수를 이용하여 1부터 N까지 출력하는 프로그램을 작성하세요

3
1 2 3
 */
public class 재귀함수_1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        recursive(n);
    }

    private static void recursive(int n) {
        if(n > 1) recursive(n-1);
        System.out.print(n+" ");
    }

}
