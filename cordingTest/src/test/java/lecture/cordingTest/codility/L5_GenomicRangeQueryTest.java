package lecture.cordingTest.codility;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class L5_GenomicRangeQueryTest {
    @Test
    public void testExampleCase() {
        L5_GenomicRangeQuery sol = new L5_GenomicRangeQuery();
        String S = "CAGCCTA";
        int[] P = {2, 5, 0};
        int[] Q = {4, 5, 6};
        int[] expected = {2, 4, 1};

        int[] result = sol.solution(S, P, Q);

        assertArrayEquals(expected, result, "Example case should return [2, 4, 1]");
    }

    @Test
    public void testSingleCharacter() {
        L5_GenomicRangeQuery sol = new L5_GenomicRangeQuery();
        String S = "A";
        int[] P = {0};
        int[] Q = {0};
        int[] expected = {1};

        int[] result = sol.solution(S, P, Q);

        assertArrayEquals(expected, result, "Single character A should return [1]");
    }

    @Test
    public void testAllTypes() {
        L5_GenomicRangeQuery sol = new L5_GenomicRangeQuery();
        String S = "ACGT";
        int[] P = {0, 1, 2, 3};
        int[] Q = {0, 1, 2, 3};
        int[] expected = {1, 2, 3, 4};

        int[] result = sol.solution(S, P, Q);

        assertArrayEquals(expected, result, "Each character should return its own impact factor");
    }

    @Test
    public void testRepeatedLetters() {
        L5_GenomicRangeQuery sol = new L5_GenomicRangeQuery();
        String S = "GGGGGGG";
        int[] P = {0, 1, 2};
        int[] Q = {6, 5, 3};
        int[] expected = {3, 3, 3};

        int[] result = sol.solution(S, P, Q);

        assertArrayEquals(expected, result, "Only Gs should result in 3");
    }

    @Test
    public void testLongRange() {
        L5_GenomicRangeQuery sol = new L5_GenomicRangeQuery();
        String S = "T".repeat(100_000); // 문자열 전체가 T로 구성
        int[] P = {0, 99999};
        int[] Q = {99999, 99999};
        int[] expected = {4, 4};

        int[] result = sol.solution(S, P, Q);

        assertArrayEquals(expected, result, "All Ts should return 4");
    }
}