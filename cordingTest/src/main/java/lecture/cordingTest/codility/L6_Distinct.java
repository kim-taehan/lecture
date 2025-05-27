package lecture.cordingTest.codility;

import java.util.HashSet;
import java.util.Set;

public class L6_Distinct {

    public int solution(int[] A){

        Set<Integer> set = new HashSet<>();
        for (int i : A) {
            set.add(i);
        }
        return set.size();
    }
}
