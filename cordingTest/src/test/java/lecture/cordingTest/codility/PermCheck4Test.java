package lecture.cordingTest.codility;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PermCheck4Test {
    PermCheck4 solution = new PermCheck4();

    @Test
    public void testIsPermutation() {
        int[] A1 = {4, 1, 3, 2};
        assertEquals(1, solution.solution(A1)); // 순열

        int[] A2 = {4, 1, 3};
        assertEquals(0, solution.solution(A2)); // 2 누락

        int[] A3 = {1};
        assertEquals(1, solution.solution(A3)); // 순열

        int[] A4 = {2};
        assertEquals(0, solution.solution(A4)); // 1 누락

        int[] A5 = {1, 2, 2};
        assertEquals(0, solution.solution(A5)); // 중복

        int[] A6 = {100000, 99999, 99998, 99997, 99996}; // 누락 많음
        assertEquals(0, solution.solution(A6));
    }
}