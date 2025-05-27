package lecture.cordingTest.codility;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class L4_MissingIntegerTest {

    L4_MissingInteger sol = new L4_MissingInteger();

    @Test
    void testExample1() {
        int[] A = {1, 3, 6, 4, 1, 2};
        assertEquals(5, sol.solution(A));
    }

    @Test
    void testExample2() {
        int[] A = {1, 2, 3};
        assertEquals(4, sol.solution(A));
    }

    @Test
    void testExample3() {
        int[] A = {-1, -3};
        assertEquals(1, sol.solution(A));
    }

    @Test
    void testWithDuplicates() {
        int[] A = {2, 2, 2, 2};
        assertEquals(1, sol.solution(A));
    }

    @Test
    void testWithLargeGap() {
        int[] A = {100, 101, 102};
        assertEquals(1, sol.solution(A));
    }

    @Test
    void testWithUnorderedArray() {
        int[] A = {3, 4, -1, 1};
        assertEquals(2, sol.solution(A));
    }
}