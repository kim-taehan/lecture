package lecture.cordingTest.ch8;

import java.util.Scanner;

/*
7*7 격자판 미로를 탈출하는 경로의 가지수를 출력하는 프로그램을 작성하세요.  출발점은 격
자의 (1, 1) 좌표이고, 탈출 도착점은 (7, 7)좌표이다. 격자판의 1은 벽이고, 0은 통로이다. 격
자판의 움직임은 상하좌우로만 움직인다

 ▣ 입력예제 1
0 0 0 0 0 0 0
0 1 1 1 1 1 0
0 0 0 1 0 0 0
1 1 0 1 0 1 1
1 1 0 0 0 0 1
1 1 0 1 1 0 0
1 0 0 0 0 0 0
▣ 출력예제 1
8
 */
public class 미로탐색_10 {

    private static int COUNT = 7;
    private static int[] X = new int[]{-1, 0, 1, 0};
    private static int[] Y = new int[]{0, -1, 0, 1};

    static int[][] miro = new int[COUNT][COUNT];

    private static int ret = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < COUNT; i++) {
            for (int j = 0; j < COUNT; j++) {
                miro[i][j] = scanner.nextInt();
            }
        }
        miro[0][0] = 1;
        dfs(0, 0);
        System.out.println(ret);
    }

    static void dfs(int y, int x) {
        if (x == COUNT - 1 && y == COUNT - 1) {
            ret++;
        } else {
            for (int i = 0; i < 4; i++) {
                int y2 = y + Y[i];
                int x2 = x + X[i];
                if (x2 >= 0 && y2 >= 0 && x2 < 7 && y2 < 7 && miro[y2][x2] == 0) {
                    miro[y2][x2] = 1;
                    dfs(y2, x2);
                    miro[y2][x2] = 0;
                }
            }
        }
    }
}
