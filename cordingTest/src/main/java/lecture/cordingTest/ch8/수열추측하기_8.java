package lecture.cordingTest.ch8;

import java.util.Scanner;

/*
4 16

3 1 2 4
 */
public class 수열추측하기_8 {

    static int n, goal;
    static int[] b;

    static int[] k;
    static int[] t;
    static int[] check;
    static int[][] history;

    static boolean end = false;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        n = scanner.nextInt();
        goal = scanner.nextInt();

        // 수열 배열 만들기
        b = new int[n];
        k = new int[n];
        t = new int[n];
        check = new int[n];
        history = new int[n][n];
        for (int i = 0; i < n; i++) {
            b[i] = dfs(n - 1, i);
            k[i] = i + 1;
        }

        dfs2(0);
    }

    static void dfs2(int depth) {
        if(end) return;
        if(depth == n){
            int sum = 0;
            for (int i = 0; i < n; i++) {
                sum += t[i] * b[i];
            }
            if (sum == goal) {
                end = true;
                for (int i : t) {
                    System.out.print(i + " ");
                }
            }
        } else{
            for (int i = 0; i < n; i++) {
                if (check[i] == 0) {
                    check[i] = 1;
                    t[depth] = k[i];
                    dfs2(depth + 1);
                    check[i] = 0;
                }
            }
        }
    }

    static int dfs(int a, int b) {
        if(history[a][b] > 0) return history[a][b];
        if(a == b || b == 0 ) return 1;
        return  history[a][b] = dfs(a - 1, b - 1) + dfs(a - 1, b);
    }

}
