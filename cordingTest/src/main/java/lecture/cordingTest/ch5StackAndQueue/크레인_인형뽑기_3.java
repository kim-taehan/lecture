package lecture.cordingTest.ch5StackAndQueue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;
import java.util.Stack;

/*
5
0 0 0 0 0
0 0 1 0 3
0 2 5 0 1
4 2 4 4 2
3 5 1 3 1
8
1 5 3 5 1 2 1 4

4


6
0 0 0 0 0 0
0 0 1 0 3 1
0 2 5 0 1 1
4 2 4 4 2 3
3 5 1 3 1 3
4 2 4 4 2 3

10
1 5 3 5 1 2 1 4 3 4

4-3-1-1-3-2-4-5-2-4
6
 */
public class 크레인_인형뽑기_3 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }
        int count = scanner.nextInt();
        int[] order = new int[count];
        for (int i = 0; i < count; i++) {
            order[i] = scanner.nextInt();
        }
        int result = solution(n, arr, count, order);
        System.out.println(result);

    }

    private static int solution(int n, int[][] arr, int count, int[] order) {

        int answer = 0;
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < count; i++) {
            int i1 = order[i]-1;
            for (int j = 0; j < n; j++) {
                int item = arr[j][i1];
                if (item != 0) {
                    arr[j][i1] = 0;
                    boolean b = pushDequeue(deque, item);
                    if(b) answer += 2;
                    break;
                }
            }
        }
        return answer;
    }

    private static boolean pushDequeue(Deque<Integer> deque, int item) {
        if(deque.isEmpty()) {
            deque.push(item);
            return false;
        }
        Integer oldItem = deque.peek();
        if (oldItem == item) {
            deque.pop();
            return true;
        }
        deque.push(item);
        return false;
    }
}
