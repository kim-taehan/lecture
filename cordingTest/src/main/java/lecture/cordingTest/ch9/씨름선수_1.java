package lecture.cordingTest.ch9;

import java.util.Arrays;
import java.util.Scanner;

/*
“A라는 지원자를 다른 모든 지원자와 일대일 비교해서 키와 몸무게 모두 A지원자 보다 높은
(크고, 무겁다) 지원자가 존재하면 A지원자는 탈락하고, 그렇지 않으면 선발된다.”
 N명의 지원자가 주어지면 위의 선발원칙으로 최대 몇 명의 선수를 선발할 수 있는지 알아내는
프로그램을 작성하세요

5
172 67
183 65
180 70
170 72
181 60

3
 */
public class 씨름선수_1 {

    static class Profile implements Comparable<Profile> {
        int height;
        int weight;

        public Profile(int height, int weight) {
            this.height = height;
            this.weight = weight;
        }

        @Override
        public int compareTo(Profile o) {
            return o.height - this.height;
        }
    }
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        Profile[] volunteers = new Profile[N];
        for (int i = 0; i < N; i++) {
            volunteers[i] = new Profile(scanner.nextInt(), scanner.nextInt());
        }
        Arrays.sort(volunteers);


        int answer = 0;
        int passWeight = Integer.MIN_VALUE;

        for (Profile volunteer : volunteers) {
            passWeight = Math.max(passWeight, volunteer.weight);
            if (passWeight == volunteer.weight) {
                answer++;
            }
        }

        System.out.println(answer);


    }
}
