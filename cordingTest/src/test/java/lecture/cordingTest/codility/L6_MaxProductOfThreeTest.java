package lecture.cordingTest.codility;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class L6_MaxProductOfThreeTest {

    L6_MaxProductOfThree solution = new L6_MaxProductOfThree();

    @Test
    public void testExample() {
        int[] A = {-3, 1, 2, -2, 5, 6};
        assertEquals(60, solution.solution(A));
    }

    @Test
    public void testAllPositive() {
        int[] A = {1, 2, 3, 4, 5};
        assertEquals(60, solution.solution(A)); // 3*4*5=60
    }

    @Test
    public void testAllNegative() {
        int[] A = {-5, -4, -3, -2, -1};
        assertEquals(-6, solution.solution(A)); // -1*-2*-3 = -6 (largest product)
    }

    @Test
    public void testMixed() {
        int[] A = {-10, -10, 5, 2};
        assertEquals(500, solution.solution(A)); // -10 * -10 * 5 = 500
    }

    @Test
    public void testMinimumLength() {
        int[] A = {1, 2, 3};
        assertEquals(6, solution.solution(A));
    }

    @Test
    public void testWithZeros() {
        int[] A = {0, -1, 3, 100, 0};
        assertEquals(0, solution.solution(A)); // 0 * 100 * 3 = 0 or other combos
    }


}