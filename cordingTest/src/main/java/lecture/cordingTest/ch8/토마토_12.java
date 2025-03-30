package lecture.cordingTest.ch8;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

/*
토마토를 창고에 보관하는 격자모양의 상자들의 크기와 익은 토마토들과 익지 않은 토마토들
의 정보가 주어졌을 때, 며칠이 지나면 토마토들이 모두 익는지, 그 최소 일수를 구하는 프로
그램을 작성하라. 단, 상자의 일부 칸에는 토마토가 들어있지 않을 수도 있다

▣입력예제 1
6 4
0 0 -1 0 0 0
0 0 1 0 -1 0
0 0 -1 0 0 0
0 0 0 0 -1 1


▣출력예제 1
4
 */
public class 토마토_12 {
    static int xCount;
    static int yCount;
    static int[][] graph;
    private static int[] X = new int[]{-1, 0, 1, 0};
    private static int[] Y = new int[]{0, -1, 0, 1};
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        yCount = scanner.nextInt();
        xCount = scanner.nextInt();
        graph = new int[xCount][yCount];

        Queue<Node> queue = new ArrayDeque<>();
        for (int i = 0; i < xCount; i++) {
            for (int j = 0; j < yCount; j++) {
                graph[i][j] = scanner.nextInt();
                if (graph[i][j] == 1) {
                    queue.add(new Node(i, j));
                }
            }
        }

        int ret = bfs(queue);

        System.out.println(ret);
    }

    static int bfs(Queue<Node> queue){
        int l = 1;
        while (!queue.isEmpty()) {

            int len = queue.size();
            for (int i = 0; i < len; i++) {
                Node temp = queue.poll();
                for (int j = 0; j < 4; j++) {
                    int dx = temp.x + X[j];
                    int dy = temp.y + Y[j];
                    if (dx >= 0 && dy >= 0 && dx < xCount && dy < yCount && graph[dx][dy] == 0) {
                        graph[dx][dy] = l;
                        queue.add(new Node(dx, dy));
                    }
                }
            }
            l++;
        }
        for (int i = 0; i < xCount; i++) {
            for (int j = 0; j < yCount; j++) {
                if (graph[i][j] == 0) {
                    return -1;
                }
            }
        }

        return l-2;
    }

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
