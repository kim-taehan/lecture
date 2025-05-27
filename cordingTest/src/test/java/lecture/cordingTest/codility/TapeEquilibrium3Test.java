package lecture.cordingTest.codility;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TapeEquilibrium3Test {
    TapeEquilibrium3 solution = new TapeEquilibrium3();

    @Test
    public void testExampleCase() {
        int[] A = {3, 1, 2, 4, 3};
        assertEquals(1, solution.solution(A));
    }

    @Test
    public void testMinimumInputSize() {
        int[] A = {1000, -1000};
        assertEquals(2000, solution.solution(A));
    }

    @Test
    public void testAllSameValues() {
        int[] A = {5, 5, 5, 5};
        assertEquals(0, solution.solution(A));
    }

    @Test
    public void testAllNegativeValues() {
        int[] A = {-3, -1, -2, -4, -3};
        assertEquals(1, solution.solution(A));
    }

    @Test
    public void testIncreasingValues() {
        int[] A = {1, 2, 3, 4, 5};
        assertEquals(3, solution.solution(A));  // 실제 최소 차이는 3
    }

    @Test
    public void testLargeInput() {
        int[] A = new int[100_000];
        for (int i = 0; i < A.length; i++) {
            A[i] = 1;
        }
        assertEquals(0, solution.solution(A));
    }
}