package lecture.cordingTest.ch2;

import java.util.Scanner;

/**
 * input : 10
 * 1 0 1 1 1 0 0 1 1 0
 * output : 10
 */
public class 점수계산 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int[] input = new int[size];
        for (int i = 0; i < size; i++) {
            input[i] = scanner.nextInt();
        }
        System.out.print(solution(size, input));
    }
    public static int solution(int size, int[] input) {

        int cnt = 0;
        int result = 0;
        for (int i : input) {
            cnt = i == 1 ? ++cnt : 0;
            result += cnt;
        }
        return result;
    }
}
