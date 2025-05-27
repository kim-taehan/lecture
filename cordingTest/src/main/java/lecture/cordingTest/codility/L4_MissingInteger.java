package lecture.cordingTest.codility;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class L4_MissingInteger {

    public int solution(int[] A){
        Set<Integer> set = new HashSet<>();

        for (int num : A) {
            if (num > 0) {
                set.add(num);
            }
        }

        for (int i = 1; i <= A.length + 1; i++) {
            if (!set.contains(i)) {
                return i;
            }
        }
        return 1;
    }
}
