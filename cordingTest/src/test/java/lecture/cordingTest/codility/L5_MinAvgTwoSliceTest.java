package lecture.cordingTest.codility;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class L5_MinAvgTwoSliceTest {


    private final L5_MinAvgTwoSlice sol = new L5_MinAvgTwoSlice();
    @Test
    public void testExampleCase() {
        int[] A = {4, 2, 2, 5, 1, 5, 8};
        int expected = 1;
        assertEquals(expected, sol.solution(A));
    }

    @Test
    public void testAllEqual() {
        int[] A = {5, 5, 5, 5, 5};
        int expected = 0; // 모든 평균 같으므로 가장 첫 인덱스
        assertEquals(expected, sol.solution(A));
    }

    @Test
    public void testNegativeValues() {
        int[] A = {-3, -5, -8, -4, -10};
        int expected = 2; // 최소 평균 슬라이스는 (-8, -4, -10)
        assertEquals(expected, sol.solution(A));
    }

    @Test
    public void testTwoElementArray() {
        int[] A = {1000, -1000};
        int expected = 0; // 유일한 슬라이스 (0,1)
        assertEquals(expected, sol.solution(A));
    }

    @Test
    public void testMinimalLengthThree() {
        int[] A = {1, 1, 1000, 1, 1};
        int expected = 0; // 슬라이스 (0,1) = 1, (3,4) = 1. 둘 다 같으나 0이 먼저
        assertEquals(expected, sol.solution(A));
    }
}