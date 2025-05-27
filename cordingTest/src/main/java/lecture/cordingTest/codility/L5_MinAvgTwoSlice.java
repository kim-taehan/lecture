package lecture.cordingTest.codility;

import java.util.Arrays;
import java.util.OptionalDouble;

public class L5_MinAvgTwoSlice {

    //for i from 0 to N - 2:
    //check average of A[i] + A[i+1] (길이 2)
    //        if i < N - 2:
    //check average of A[i] + A[i+1] + A[i+2] (길이 3)
    public int solution(int[] A) {

        double minValue = Double.MAX_VALUE;
        int minIndex = 0;
        for (int i = 0; i < A.length-1; i++) {
            double avg2 = getAvg(A[i], A[i + 1]);
            if( avg2 < minValue) {
                minValue = avg2;
                minIndex = i;
            }
            if (i < A.length - 2) {
                double avg3 = getAvg(A[i], A[i + 1], A[i + 2]);
                if( avg3 < minValue) {
                    minValue = avg3;
                    minIndex = i;
                }
            }
        }
        return minIndex;
    }

    double getAvg(int... ints) {
        int sum = 0;
        for (int anInt : ints) {
            sum+=anInt;
        }
        return (double) sum /ints.length;
    }
}
