package lecture.cordingTest.ch7;

import java.util.Scanner;

/*
 5 9
 1 2
 1 3
 1 4
 2 1
 2 3
 2 5
 3 4
 4 2
 4 5

 6
 */
public class 경로탐색_인접행렬_10 {

    private static int[][] graph;
    private static int[] history;
    private static int ret;
    private static int n;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        int trunk = scanner.nextInt();

        graph = new int[n+1][n+1];
        history  = new int[n+1];
        for (int i = 1; i <= trunk; i++) {
            graph[scanner.nextInt()][scanner.nextInt()] = 1;
        }
        dfs(1);
        System.out.println(ret);
    }

    private static void dfs(int node) {

        if (node == n) {
            ret++;
            return;
        }

        history[node] = 1;
        for (int i = 1; i <= n; i++) {
            if (graph[node][i] == 1 && history[i] == 0) {
                dfs(i);
            }
        }
        history[node] = 0;
    }
}
