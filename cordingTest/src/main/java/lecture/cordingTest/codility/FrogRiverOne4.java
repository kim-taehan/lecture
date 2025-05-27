package lecture.cordingTest.codility;

import java.util.HashSet;
import java.util.Set;

public class FrogRiverOne4 {

    public int solution(int X, int[] A) {
        // Implement your solution here
        // int[] A = {1, 3, 1, 4, 2, 3, 5, 4};
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < A.length; i++) {
            if (A[i] <= X) {
                set.add(A[i]);
                if (set.size() == X) {
                    return i;
                }
            }
        }
        return -1;
    }
}
