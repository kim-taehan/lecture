package lecture.cordingTest.ch6Sort;

import java.util.Arrays;
import java.util.Scanner;

/*
9
120 125 152 130 135 135 143 127 160


30
122 123 125 125 128 130 133 137 138 138 140 141 142 143 145 147 149 149 154 154 155 157 161 167 167 167 161 170 173 173
 */
public class 장난꾸러기_6 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        int[] array = new int[count];
        for (int i = 0; i < count; i++) {
            array[i] = scanner.nextInt();
        }
        for (int i : solution(count, array)) {
            System.out.print(i+" ");
        }
    }

    private static int[] solution(int count, int[] array) {

        int[] sortArray = Arrays.copyOf(array, count);
        Arrays.sort(sortArray);

        int[] answer = new int[2];
        int k=0;
        for (int i = 0; i < count; i++) {
            if (array[i] != sortArray[i]) {
                answer[k++] = i+1;
            }
        }
        return answer;
    }
}
