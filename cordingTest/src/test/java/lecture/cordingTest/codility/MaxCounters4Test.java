package lecture.cordingTest.codility;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaxCounters4Test {

    MaxCounters4 sol = new MaxCounters4();
    @Test
    void testSolution() {

        int N = 5;
        int[] A = {3, 4, 4, 6, 1, 4, 4};
        int[] expected = {3, 2, 2, 4, 2};

        assertArrayEquals(expected, sol.solution(N, A));
    }

    @Test
    void testAllIncrease() {

        int N = 3;
        int[] A = {1, 2, 3, 1, 2, 3};
        int[] expected = {2, 2, 2};

        assertArrayEquals(expected, sol.solution(N, A));
    }

    @Test
    void testMaxCounterAtStart() {

        int N = 4;
        int[] A = {5, 1, 2, 3, 4};
        int[] expected = {1, 1, 1, 1};

        assertArrayEquals(expected, sol.solution(N, A));
    }

    @Test
    void testNoMaxCounter() {
        int N = 2;
        int[] A = {1, 2, 1, 2, 1};
        int[] expected = {3, 2};

        assertArrayEquals(expected, sol.solution(N, A));
    }

    @Test
    void testOnlyMaxCounter() {

        int N = 3;
        int[] A = {4, 4, 4, 4};
        int[] expected = {0, 0, 0};

        assertArrayEquals(expected, sol.solution(N, A));
    }

}