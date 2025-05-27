package lecture.cordingTest.codility;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class L6_NumberOfDiscIntersectionsTest {
    L6_NumberOfDiscIntersections solution = new L6_NumberOfDiscIntersections();

    @Test
    void testExampleCase() {
        int[] A = {1, 5, 2, 1, 4, 0};
        int result = solution.solution(A);
        assertEquals(11, result);
    }

    @Test
    void testNoIntersection() {
        int[] A = {0, 0, 0, 0};
        int result = solution.solution(A);
        assertEquals(0, result);
    }

    @Test
    void testAllIntersect() {
        int[] A = {10, 10, 10};
        int result = solution.solution(A);
        assertEquals(3, result); // (0,1), (0,2), (1,2)
    }

    @Test
    void testSingleDisk() {
        int[] A = {0};
        int result = solution.solution(A);
        assertEquals(0, result);
    }

    @Test
    void testOverLimitIntersections() {
        int[] A = new int[20_000];
        Arrays.fill(A, 10_000);
        int result = solution.solution(A);
        assertEquals(-1, result);
    }
}