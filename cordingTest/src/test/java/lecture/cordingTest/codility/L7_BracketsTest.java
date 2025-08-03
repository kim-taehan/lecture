package lecture.cordingTest.codility;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class L7_BracketsTest {
    L7_Brackets solution = new L7_Brackets();

    @Test
    void testProperlyNestedStrings() {
        assertEquals(1, solution.solution("{[()()]}"));
        //assertEquals(1, solution.solution("()"));
        //assertEquals(1, solution.solution("([]{})"));
        //assertEquals(1, solution.solution(""));  // Empty string
    }

    @Test
    void testImproperlyNestedStrings() {
        assertEquals(0, solution.solution("([)()]"));
        assertEquals(0, solution.solution("("));
        assertEquals(0, solution.solution("([)]"));
        assertEquals(0, solution.solution("((()))]"));
        assertEquals(0, solution.solution("{[(])}"));
    }

    @Test
    void testSingleCharacter() {
        assertEquals(0, solution.solution("["));
        assertEquals(0, solution.solution("]"));
        assertEquals(0, solution.solution("{"));
        assertEquals(0, solution.solution(")"));
    }

    @Test
    void testLongNestedString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 100_000; i++) sb.append('(');
        for (int i = 0; i < 100_000; i++) sb.append(')');
        assertEquals(1, solution.solution(sb.toString()));
    }
}