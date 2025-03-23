package lecture.cordingTest.ch8;

import java.util.Scanner;

/*

설명
    철수는 그의 바둑이들을 데리고 시장에 가려고 한다. 그런데 그의 트럭은 C킬로그램 넘게 태울수가 없다.
    철수는 C를 넘지 않으면서 그의 바둑이들을 가장 무겁게 태우고 싶다.
    N마리의 바둑이와 각 바둑이의 무게 W가 주어지면, 철수가 트럭에 태울 수 있는 가장 무거운 무게를 구하는 프로그램을 작성하세요.

입력
    첫 번째 줄에 자연수 C(1<=C<=100,000,000)와 N(1<=N<=30)이 주어집니다.
    둘째 줄부터 N마리 바둑이의 무게가 주어진다.

출력
    첫 번째 줄에 가장 무거운 무게를 출력한다.


259 5
81
58
42
33
61

242


10000 12
2757
5674
9996
2346
4673
5673
1236
4734
754
4534
3563
1



9997
 */
public class 바둑이_승차_2 {

    static int total = 0;
    static int[] arr;
    static int max;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        max = scanner.nextInt();
        int n = scanner.nextInt();
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        dfs(0, 0);
        System.out.println(total);
    }

    private static void dfs(int index, int sum){
        if(index >= arr.length) return;
        int tempTotal = sum + arr[index];
        if (tempTotal <= max) {
            total = Math.max(total, tempTotal);
            dfs(index+1, tempTotal);
        }
        dfs(index+1, sum);
    }
}
