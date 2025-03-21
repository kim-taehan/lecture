package lecture.cordingTest.ch7;

import java.util.ArrayList;
import java.util.List;
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
public class 경로탐색_인접리스트_11 {

    private static List<Integer>[] graph;
    private static int[] history;
    private static int ret;
    private static int n;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        int trunk = scanner.nextInt();

        graph = new ArrayList[n + 1];//new int[n+1][n+1];
        history  = new int[n+1];

        for (int i = 0; i < n + 1; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 1; i <= trunk; i++) {
            List<Integer> list = graph[scanner.nextInt()];

            list.add(scanner.nextInt());
        }
        history[1] = 1;
        dfs(1);
        System.out.println(ret);
    }

    private static void dfs(int node) {

        if (node == n) {
            ret++;
            return;
        }

        for (Integer i : graph[node]) {
            if (history[i] == 0) {
                history[i] = 1;
                dfs(i);
                history[i] = 0;
            }
        }
    }
}
