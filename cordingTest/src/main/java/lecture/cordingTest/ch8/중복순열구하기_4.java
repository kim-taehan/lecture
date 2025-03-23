package lecture.cordingTest.ch8;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
1부터 N까지 번호가 적힌 구슬이 있습니다. 이 중 중복을 허락하여 M번을 뽑아 일렬로 나열 하는 방법을 모두 출력합니다


입력설명
    첫 번째 줄에 자연수 N(3<=N<=10)과 M(2<=M<=N) 이 주어집니다.
출력설명
    첫 번째 줄에 결과를 출력합니다.
    출력순서는 사전순으로 오름차순으로 출력합니다.
입력예제 1
3 2

출력예제 1
1 1
1 2
1 3
2 1
2 2
2 3
3 1
3 2
3 3


 */
public class 중복순열구하기_4 {

    static List<String> ret = new ArrayList<>();
    static int N, M;
    static int[] pm;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        M = scanner.nextInt();

        pm = new int[M];
        dfs(0);

        for (String s : ret) {
            System.out.println(s);
        }

    }

    static void dfs(int depth){

        if (depth == M) {
            addList();
        } else {
            for (int i = 1; i <= N; i++) {
                pm[depth] = i;
                dfs(depth + 1);
            }
        }
    }

    private static void addList() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            sb.append(pm[i]).append(" ");
        }
        ret.add(sb.toString());
    }
}
