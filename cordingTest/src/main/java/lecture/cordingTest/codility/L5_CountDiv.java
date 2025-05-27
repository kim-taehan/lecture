package lecture.cordingTest.codility;

public class L5_CountDiv {

    public int solution(int A, int B, int K) {

        boolean isCheck = false;
        int ret = 0;
        for (int i = A; i <= B; ) {
            if(isCheck) {
                ret++;
                i += K;
            } else {
                if (i % K == 0) {
                    isCheck = true;
                    ret++;
                    i += K;
                } else i++;
            }
        }
        return ret;
    }
}
