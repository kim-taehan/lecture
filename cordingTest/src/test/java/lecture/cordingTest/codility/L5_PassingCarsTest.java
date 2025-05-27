package lecture.cordingTest.codility;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class L5_PassingCarsTest {
    L5_PassingCars solution = new L5_PassingCars();

    @Test
    void testExampleCase() {
        int[] A = {0, 1, 0, 1, 1};
        assertEquals(5, solution.solution(A));
    }

    @Test
    void testAllEastCars() {
        int[] A = {0, 0, 0, 0};
        assertEquals(0, solution.solution(A));
    }

    @Test
    void testAllWestCars() {
        int[] A = {1, 1, 1, 1};
        assertEquals(0, solution.solution(A));
    }

    @Test
    void testMaxLimitExceeded() {
        int[] A = new int[100_000];
        for (int i = 0; i < 50_000; i++) {
            A[i] = 0;
        }
        for (int i = 50_000; i < 100_000; i++) {
            A[i] = 1;
        }
        assertEquals(-1, solution.solution(A));
    }
}