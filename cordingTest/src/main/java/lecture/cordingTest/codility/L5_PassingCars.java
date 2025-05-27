package lecture.cordingTest.codility;

public class L5_PassingCars {

    public int solution(int[] A) {

        int sum = 0;
        int left = 0;
        for (int car : A) {
            if (car == 0) {
                left++;
            } else {
                sum += left;
                if(1_000_000_000 < sum){
                    return -1;
                }
            }
        }
        return sum;
    }
}
