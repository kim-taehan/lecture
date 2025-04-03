package lecture.cordingTest.ch10;

import java.util.Arrays;
import java.util.Scanner;

/*
다음과 같이 여러 단위의 동전들이 주어져 있을때 거스름돈을 가장 적은 수의 동전으로 교환
해주려면 어떻게 주면 되는가? 각 단위의 동전은 무한정 쓸 수 있다.


▣입력예제 1
3
1 2 5
15

▣출력예제 1
3

4
10 7 3 2
18

5

5
1 8 20 25 50
129

5

*/
public class 최소동전갯수_5 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[] coins = new int[n];

        for (int i = 0; i < n; i++) {
            coins[i] = scanner.nextInt();
        }

        int amount = scanner.nextInt();

        int ret = solution(coins, amount);
        System.out.println(ret);
    }

    static int solution(int[] coins, int amount) {

        Arrays.sort(coins);

        int[] amounts = new int[amount + 1];
        for (int i = 0; i < amounts.length; i++) {
            if(i < coins[0]) amounts[i] = 0;
            else amounts[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < coins.length; i++) {
            int coin = coins[i];
//            amounts[coin] = 1;
            for (int j = coin; j < amounts.length; j++) {
                    amounts[j] = Math.min(amounts[j-coin] + 1, amounts[j]);
            }
        }
        return amounts[amount];
    }
}
