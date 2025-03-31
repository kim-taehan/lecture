package lecture.cordingTest.ch9;

import java.util.Arrays;
import java.util.Scanner;

/*
현수는 이 정보를 바탕으로 피로연 장소에 동시에 존재하는 최대 인원수를 구하여 그 인원을 수용할 수 있는 장소를 빌리려고 합니다. 여러분이 현수를 도와주세요.
만약 한 친구가 오는 시간 13, 가는시간 15라면 이 친구는 13시 정각에 피로연 장에 존재하는 것이고 15시 정각에는 존재하지 않는다고 가정합니다.

5
14 18
12 15
15 20
20 30
5 14

2

 */
public class 결혼식_3 {

    static class Friend implements Comparable<Friend> {
        int time;
        int inAndOut; // in 1, out -1

        public Friend(int time, int inAndOut) {
            this.time = time;
            this.inAndOut = inAndOut;
        }

        @Override
        public int compareTo(Friend o) {

            if (this.time == o.time) {
                return this.inAndOut - o.inAndOut;
            }
            return this.time - o.time;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Friend[] friends = new Friend[n*2];

        for (int i = 0; i < friends.length; i++) {
            friends[i] = new Friend(scanner.nextInt(), 1);
            friends[++i] = new Friend(scanner.nextInt(), -1);
        }

        int ret = solution(friends);
        System.out.println(ret);
    }

    static int solution(Friend[] friends) {

        Arrays.sort(friends);
        int maxCount = 0;
        int currentCount = 0;

        for (Friend friend : friends) {
            currentCount += friend.inAndOut;
            maxCount = Math.max(maxCount, currentCount);
        }

        return maxCount;
    }
}
