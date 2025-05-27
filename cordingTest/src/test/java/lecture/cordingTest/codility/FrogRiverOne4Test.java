package lecture.cordingTest.codility;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FrogRiverOne4Test {

    FrogRiverOne4 solution = new FrogRiverOne4();

    @Test
    void testExampleCase() {
        int X = 5;
        int[] A = {1, 3, 1, 4, 2, 3, 5, 4};
        assertEquals(6, solution.solution(X, A));
    }

    @Test
    void testCannotCross() {
        int X = 3;
        int[] A = {1, 1, 1, 1};
        assertEquals(-1, solution.solution(X, A));
    }

    @Test
    void testCrossImmediately() {
        int X = 1;
        int[] A = {1};
        assertEquals(0, solution.solution(X, A));
    }

    @Test
    void testLateLeaf() {
        int X = 3;
        int[] A = {1, 3, 1, 1, 2};
        assertEquals(4, solution.solution(X, A));
    }

    @Test
    void testLargeInput() {
        int X = 100000;
        int[] A = new int[100000];
        for (int i = 0; i < 100000; i++) {
            A[i] = i + 1;
        }
        assertEquals(99999, solution.solution(X, A));
    }

}