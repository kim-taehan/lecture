package lecture.cordingTest.ch3Array;

import java.util.Scanner;

public class 소수_애라토스테네스체_5 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        System.out.print(solution(size));
    }
    public static int solution(int size) {
        int[] items = new int[size+1];
        int result = 0;
        for (int i = 2; i <= size; i++) {
            if(items[i] == 0) {
                result++;
                for (int j = i; j <= size; j = j + i) {
                    items[j] = 1;
                }
            }
        }
        return result;
    }
}
