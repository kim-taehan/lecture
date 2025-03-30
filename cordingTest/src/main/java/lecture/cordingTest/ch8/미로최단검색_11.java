package lecture.cordingTest.ch8;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

/*
 7*7 격자판 미로를 탈출하는 최단경로의 길이를 출력하는 프로그램을 작성하세요. 경로의 길
이는 출발점에서 도착점까지 가는데 이동한 횟수를 의미한다. 출발점은 격자의 (1, 1) 좌표이
고, 탈출 도착점은 (7, 7)좌표이다. 격자판의 1은 벽이고, 0은 도로이다

▣ 입력예제 1
0 0 0 0 0 0 0
0 1 1 1 1 1 0
0 0 0 1 0 0 0
1 1 0 1 0 1 1
1 1 0 1 0 0 0
1 0 0 0 1 0 0
1 0 1 0 0 0 0
 ▣ 출력예제 1
 12

 */
public class 미로최단검색_11 {

    private static int COUNT = 7;
    private static int[] X = new int[]{-1, 0, 1, 0};
    private static int[] Y = new int[]{0, -1, 0, 1};

    static int[][] miro = new int[COUNT][COUNT];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < COUNT; i++) {
            for (int j = 0; j < COUNT; j++) {
                miro[i][j] = scanner.nextInt();
            }
        }
        miro[0][0] = 1;
        System.out.println(bfs());
    }


    static class Point {
        int x; int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public boolean isLast() {
            return x == COUNT - 1 && y == COUNT - 1;
        }

        public boolean isNode(){
            return x >= 0 && y >= 0 && x < 7 && y < 7 && miro[x][y] == 0;
        }

        public Point next(int x, int y) {
            return new Point(this.x + x, this.y + y);
        }
    }


    static int bfs() {

        Queue<Point> points = new ArrayDeque<>();
        points.add(new Point(0, 0));
        miro[0][0] = 0;

        while (!points.isEmpty()) {
            int len = points.size();
            for (int i = 0; i < len; i++) {
                Point point = points.poll();
                if(point.isLast()) {
                    return miro[point.x][point.y];
                } else {
                    for (int j = 0; j < 4; j++) {
                        Point next = point.next(X[j], Y[j]);
                        if (next.isNode()) {
                            miro[next.x][next.y] = miro[point.x][point.y] + 1;
                            points.add(next);
                        }
                    }
                }
            }
        }
        return -1;
    }
}
