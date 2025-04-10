package lecture.cordingTest.ch7;

import java.util.Scanner;

/*
재귀함수를 이용한 피보나치
10

55


1 1 2 3 5 8 13 21 34 55
 */
public class 피보나치_4_RE {

    static int[] fibo;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        fibo = new int[n+1];
        recursive(n);
        for(int i=1; i<=n; i++){
            System.out.print(fibo[i] + " ");
        }
    }

    private static int recursive(int n) {
        if(fibo[n] != 0) return fibo[n];
        if(n <= 2) return fibo[n] = 1;
        return fibo[n] = recursive(n - 1) + recursive(n - 2);
    }
}
