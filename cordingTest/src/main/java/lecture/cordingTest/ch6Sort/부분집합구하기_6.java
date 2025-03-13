package lecture.cordingTest.ch6Sort;

import java.util.Scanner;

public class 부분집합구하기_6 {

    static int n;
    static int[] ch;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        ch = new int[n + 1];
        dfs(1);
    }

    private static void dfs(int l) {
        if (l == n + 1) {
            for (int i= 1; i<n+1; i++) {
                if(ch[i] == 1) System.out.print(i + " ");
            }
            System.out.println();
        } else {
            ch[l] = 1;
            dfs(l+1);
            ch[l] = 0;
            dfs(l+1);
        }
    }
}
