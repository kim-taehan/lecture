package lecture.cordingTest.codility;

import java.sql.Array;

public class MaxCounters4 {

    public int[] solution(int N, int[] A){
        // A[i] = X이고, 1 ≤ X ≤ N이라면, 작업 K는 increase(X)입니다.
        // A[i] = N + 1이라면, 작업 K는 max counter입니다.
        int[] ret = new int[N];

        int max = Integer.MIN_VALUE;
        int temp = Integer.MIN_VALUE;
        for (int i = 0; i < A.length; i++) {
            int value = A[i];
            if (value >= 1 && value <= N) {
                ret[value - 1] = Math.max(ret[value - 1], max) +1;
                temp = Math.max(temp, ret[value - 1]);
            } else if (value == N + 1) {
                max = temp;
            }
        }
        for (int i = 0; i < N; i++) {
            ret[i] = Math.max(ret[i], max);
        }

        return ret;
    }
}
