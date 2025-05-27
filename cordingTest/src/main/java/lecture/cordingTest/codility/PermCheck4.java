package lecture.cordingTest.codility;

import java.util.Arrays;

// 배열 A가 순열이라면 1을 반환하고, 그렇지 않다면 0을 반환합니다.
public class PermCheck4 {

    public int solution(int[] A){
        Arrays.sort(A);
        if(A[0] != 1) return 0;
        for (int i = 0; i < A.length-1; i++) {
            if(A[i]+1 != A[i+1]) return 0;
        }
        return 1;
    }
}
