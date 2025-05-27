package lecture.cordingTest.codility;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class L5_CountDivTest {

    L5_CountDiv solution = new L5_CountDiv();

    @Test
    void testExample() {
        assertEquals(3, solution.solution(6, 11, 2)); // 6, 8, 10
    }

    @Test
    void testSameStartEnd() {
        assertEquals(1, solution.solution(10, 10, 5)); // 10
        assertEquals(0, solution.solution(10, 10, 7)); // x
    }

    @Test
    void testLargeRange() {
        assertEquals(1_000_000_001, solution.solution(0, 2_000_000_000, 2));
    }

    @Test
    void testFromZero() {
        assertEquals(6, solution.solution(0, 10, 2)); // 0, 2, 4, 6, 8, 10 → 6개
    }
}