package lecture.cordingTest.ch7;

import java.util.Scanner;

public class 팩토리얼_3_RE {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(recursive(n));

    }

    private static int recursive(int n) {
        if(n == 1) return 1;
        return n * recursive(n - 1);
    }
}
