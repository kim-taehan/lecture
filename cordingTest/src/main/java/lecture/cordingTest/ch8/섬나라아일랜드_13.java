package lecture.cordingTest.ch8;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

/*
N*N의 섬나라 아일랜드의 지도가 격자판의 정보로 주어집니다. 각 섬은 1로 표시되어 상하좌
우와 대각선으로 연결되어 있으며, 0은 바다입니다. 섬나라 아일랜드에 몇 개의 섬이 있는지
구하는 프로그램을 작성하세요.


7
1 1 0 0 0 1 0
0 1 1 0 1 1 0
0 1 0 0 0 0 0
0 0 0 1 0 1 1
1 1 0 1 1 0 0
1 0 0 0 1 0 0
1 0 1 0 1 0 0


5
 */
public class 섬나라아일랜드_13 {

    static int N;
    static int[][] graph;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();

        graph = new int[N][N];
        Queue<Node> queue = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int value = scanner.nextInt();
                if (value == 1) {
                    queue.add(new Node(j, i));
                }
                graph[i][j] = value;
            }
        }

        int ret = 0;
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (graph[node.y][node.x] == 1) {
                ret++;
                dfs(node.x, node.y);
            }
        }
        System.out.println(ret);
    }

    static int[] X = new int[]{0, 0, -1, 1, -1, 1, -1, 1};
    static int[] Y = new int[]{-1, 1, 0, 0, 1, -1, -1, 1};

    static void dfs(int x, int y) {
        for (int i = 0; i < 8; i++) {
            int dx = x + X[i];
            int dy = y + Y[i];
            if (dx >= 0 && dy >= 0 && dx < N && dy < N && graph[dy][dx] == 1) {
                graph[dy][dx] = 0;
                dfs(dx, dy);
            }
        }
    }

    static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}
