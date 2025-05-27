package lecture.cordingTest.codility;

public class L5_GenomicRangeQuery {

    public int[] solution(String S, int[] P, int[] Q) {
        int N = S.length();
        int M = P.length;
        int[][] prefix = new int[4][N + 1];

        for (int i = 0; i < N; i++) {
            int a = 0, c = 0, g = 0, t = 0;
            switch (S.charAt(i)) {
                case 'A':
                    a = 1;
                    break;
                case 'C':
                    c = 1;
                    break;
                case 'G':
                    g = 1;
                    break;
                case 'T':
                    t = 1;
                    break;
            }
            prefix[0][i + 1] = prefix[0][i] + a;
            prefix[1][i + 1] = prefix[1][i] + c;
            prefix[2][i + 1] = prefix[2][i] + g;
            prefix[3][i + 1] = prefix[3][i] + t;
        }

        int[] result = new int[M];
        for (int k = 0; k < M; k++) {
            int from = P[k], to = Q[k] + 1;
            if (prefix[0][to] - prefix[0][from] > 0) result[k] = 1;
            else if (prefix[1][to] - prefix[1][from] > 0) result[k] = 2;
            else if (prefix[2][to] - prefix[2][from] > 0) result[k] = 3;
            else result[k] = 4;
        }
        return result;
    }
}
