package lecture.cordingTest.ch8;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
10이하의 N개의 자연수가 주어지면 이 중  M개를 뽑아 일렬로 나열하는 방법을 모두 출력합
니다.


입력설명
    첫 번째 줄에 자연수 N(3<=N<=10)과 M(2<=M<=N) 이 주어집니다.
    두 번째 줄에 N개의 자연수가 오름차순으로 주어집니다.

출력설명
    첫 번째 줄에 결과를 출력합니다.
    출력순서는 사전순으로 오름차순으로 출력합니다.

입력예제 1
3 2
3 6 9

출력예제 1
3 6
3 9
6 3
6 9
9 3
9 6

입력예제 2
4 3
1 2 3 4

출력예제 1
1 2 3
1 2 4
1 3 2
1 3 4
1 4 2
1 4 3

 */
public class 순열구하기_6 {

    static int N, M;
    static int[] arr;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        M = scanner.nextInt();
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = scanner.nextInt();
        }

        dfs(0, new ArrayList<>());

    }

    static void dfs(int l, List<Integer> list) {

        if (l == M) {
            for (Integer i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
        } else {
            for (int i = 0; i < N; i++) {
                if(!list.contains(arr[i])){
                    list.add(arr[i]);
                    dfs(l + 1, list);
                    list.remove(l);
                }
            }
        }
    }

}
