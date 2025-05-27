package lecture.cordingTest.codility;

import java.util.Arrays;

public class L6_MaxProductOfThree {

    public int solution(int[] A){
        Arrays.sort(A);
        int n = A.length;
        int max1 = A[n - 1] * A[n - 2] * A[n - 3];
        int max2 = A[0] * A[1] * A[n - 1];
        return Math.max(max1, max2);
    }
}
