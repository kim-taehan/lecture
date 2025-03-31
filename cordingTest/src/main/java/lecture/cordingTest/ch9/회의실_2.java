package lecture.cordingTest.ch9;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

/*
한 개의 회의실이 있는데 이를 사용하고자 하는 n개의 회의들에 대하여 회의실 사용표를 만들
려고 한다. 각 회의에 대해 시작시간과 끝나는 시간이 주어져 있고, 각 회의가 겹치지 않게 하
면서 회의실을 사용할 수 있는 최대수의 회의를 찾아라. 단, 회의는 한번 시작하면 중간에 중
단될 수 없으며 한 회의가 끝나는 것과 동시에 다음 회의가 시작될 수 있다.

입력예제 1
5
1 4
2 3
3 5
4 6
5 7

출력예제 1
3


5
3 3
1 3
2 3
4 6
5 7

3
 */
public class 회의실_2 {


    static class Meeting implements Comparable<Meeting>{
        public Meeting(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }

        int startTime;
        int endTime;

        @Override
        public int compareTo(Meeting o) {

            if (this.endTime == o.endTime) {
                return this.startTime- o.startTime;
            }
            return this.endTime- o.endTime;
        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        Meeting[] arr = new Meeting[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new Meeting(scanner.nextInt(), scanner.nextInt());
        }
        int solution = solution(arr);
        System.out.println(solution);

    }

    static int solution(Meeting[] arr) {
        Arrays.sort(arr);
        int ret = 0;
        int lastTime = 0;
        for (Meeting meeting : arr) {
            if (meeting.startTime >= lastTime) {
                ret++;
                lastTime = meeting.endTime;
            }
        }
        return ret;
    }
}
