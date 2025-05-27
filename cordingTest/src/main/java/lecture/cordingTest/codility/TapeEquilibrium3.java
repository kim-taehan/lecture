package lecture.cordingTest.codility;

import java.util.Arrays;

public class TapeEquilibrium3 {

    public int solution(int[] A){

        System.out.println("Arrays.toString(A) = " + Arrays.toString(A));
        int left = A[0];
        int right = Arrays.stream(A).sum()-left;
        int sum = Math.abs(left - right);
        for (int i = 1; i < A.length-1; i++) {
            left += A[i];
            right -= A[i];
            sum = Math.min(sum, Math.abs(left - right));
        }
        return sum;
    }

}
