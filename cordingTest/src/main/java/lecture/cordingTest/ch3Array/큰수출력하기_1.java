package lecture.cordingTest.ch3Array;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * N개의 정수를 입력받아, 자신의 바로 앞 수보다 큰 수만 출력하는 프로그램을 작성하세요.
 * input : 6
 *         7 3 9 5 6 12
 * output : 7 9 6 12
 */
public class 큰수출력하기_1 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int[] input = new int[size];
        for (int i = 0; i < size; i++) {
            input[i] = Integer.parseInt(scanner.next());
        }
        List<Integer> solution = solution(input);
        for (int i : solution) {
            System.out.print(i + " ");
        }
    }
    public static List<Integer> solution(int[] input) {
        List<Integer> result = new ArrayList<>();
        int preNumber = -1;
        for (int currentNumber : input) {
            if (preNumber < currentNumber) {
                result.add(currentNumber);
            }
            preNumber = currentNumber;
        }
        return result;
    }
}
