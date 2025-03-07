package lecture.cordingTest.ch2;

import java.util.Scanner;

/**
 * 3. 가위 바위 보 (1:가위, 2:묵, 3:빠)
 * input : 5
 *         2 3 3 1 3
 *         1 1 2 2 3
 * output : A
 *          B
 *          A
 *          B
 *          D
 */
public class Mukchippa {


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int[] inputA = new int[size];
        for (int i = 0; i < size; i++) {
            inputA[i] = scanner.nextInt();
        }
        int[] inputB = new int[size];
        for (int i = 0; i < size; i++) {
            inputB[i] = scanner.nextInt();
        }
        String[] result = solution(size, inputA, inputB);
        for (String s : result) {
            System.out.println(s);
        }
    }

    private static String[] solution(int size, int[] inputAs, int[] inputBs) {
        String[] result = new String[size];
        // (1:가위, 2:바위, 3:보)
        for (int i = 0; i < size; i++) {
            int inputA = inputAs[i];
            int inputB = inputBs[i];
            int minus = inputA - inputB;
            if (inputA == inputB) {
                result[i] = "D";
            } else if (minus == 1 || minus == -2) {
                result[i] = "A";
            } else {
                result[i] = "B";
            }
        }
        return result;
    }
}
