package lecture.cordingTest.codility;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class 이진갭 {
    public int solution(int[] A) {
        int N = A.length;
        long totalSum = (long)(N + 1) * (N + 2) / 2;  // 1부터 N+1까지 합
        long arrSum = 0;
        for (int num : A) {
            arrSum += num;
        }
        return (int)(totalSum - arrSum);
    }



    public static void main(String[] args) {
        이진갭 이진갭 = new 이진갭();
        int solution = 이진갭.solution(new int[]{2, 3, 5, 1, 6});

        System.out.println("solution = " + solution);

    }
}
