package lecture.cordingTest.codility;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class L6_TriangleTest {

    @Test
    public void testTriangularExists() {
        L6_Triangle s = new L6_Triangle();
        int[] A = {10, 2, 5, 1, 8, 20};
        assertEquals(1, s.solution(A));
    }

    @Test
    public void testTriangularDoesNotExist() {
        L6_Triangle s = new L6_Triangle();
        int[] A = {10, 50, 5, 1};
        assertEquals(0, s.solution(A));
    }

    @Test
    public void testShortArray() {

        L6_Triangle s = new L6_Triangle();
        int[] A = {1, 2};
        assertEquals(0, s.solution(A));
    }

    @Test
    public void testAllZeros() {
        L6_Triangle s = new L6_Triangle();
        int[] A = {0, 0, 0, 0};
        assertEquals(0, s.solution(A));
    }

    @Test
    public void testNegativeNumbers() {
        L6_Triangle s = new L6_Triangle();
        int[] A = {-3, -2, -1, 0};
        assertEquals(0, s.solution(A));
    }

    @Test
    public void testLargePositiveTriplet() {
        L6_Triangle s = new L6_Triangle();
        int[] A = {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE};
        assertEquals(1, s.solution(A));
    }

    @Test
    public void testLargeMixed() {
        L6_Triangle s = new L6_Triangle();
        int[] A = {-1000000, 500000000, 500000000};
        assertEquals(0, s.solution(A));
    }


}