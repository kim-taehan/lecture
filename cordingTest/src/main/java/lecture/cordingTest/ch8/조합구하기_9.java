package lecture.cordingTest.ch8;

import java.util.Scanner;

/*
4 2

1 2
1 3
1 4
2 1
2 3
2 4
3 4
 */
public class 조합구하기_9 {

    static int[] data;
    static int n, m;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        n = scanner.nextInt();
        m = scanner.nextInt();
        data = new int[m];

        dfs(0, 1);
    }

    static void dfs(int depth, int k) {
        if (depth == m) {
            for (int value : data) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
        else {
            for (int i = k; i <= n; i++) {
                data[depth] = i;
                dfs(depth+1, i+1);
            }
        }
    }

}