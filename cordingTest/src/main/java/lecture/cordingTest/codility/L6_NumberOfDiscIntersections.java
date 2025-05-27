package lecture.cordingTest.codility;

import java.util.Arrays;

public class L6_NumberOfDiscIntersections {

    public int solution(int[] A) {
        int N = A.length;
        long[] lower = new long[N];
        long[] upper = new long[N];

        for (int i = 0; i < N; i++) {
            lower[i] = (long)i - A[i];
            upper[i] = (long)i + A[i];
        }

        Arrays.sort(lower);
        Arrays.sort(upper);

        int intersections = 0;
        int j = 0;

        for (int i = 0; i < N; i++) {
            while (j < N && upper[i] >= lower[j]) {
                j++;
            }
            intersections += j - i - 1;
            if (intersections > 10_000_000) return -1;
        }

        return intersections;
    }
}
