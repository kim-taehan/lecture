package lecture.cordingTest.ch7;

import java.util.*;

/*
6 9
1 3
1 4
2 1
2 5
3 4
4 5
4 6
6 2
6 5


2 : 3
3 : 1
4 : 1
5 : 2
6 : 2
 */
public class 그래프최단거리_12_RE {

    private static List<Integer>[] graph;
    private static int[] distance;
    private static int n;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        int trunk = scanner.nextInt();

        graph = new ArrayList[n + 1];//new int[n+1][n+1];
        distance  = new int[n+1];

        for (int i = 0; i < n + 1; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 1; i <= trunk; i++) {
            List<Integer> list = graph[scanner.nextInt()];
            list.add(scanner.nextInt());
        }
        distance[1] = -1;
        bfs(1);

        for (int i = 2; i <= n; i++) {
            System.out.println(i + " = " + distance[i]);
        }
    }
    private static void bfs(int node) {

        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(1);

        int level = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Integer currentNode = queue.poll();
                for (Integer next : graph[currentNode]) {
                    if (distance[next] == 0) {
                        distance[next] = level;
                        queue.add(next);
                    }
                }
            }
            level++;
        }

    }

}
