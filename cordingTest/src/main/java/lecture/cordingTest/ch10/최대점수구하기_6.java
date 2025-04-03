package lecture.cordingTest.ch10;

import java.util.Scanner;

/*
이번 정보올림피아드대회에서 좋은 성적을 내기 위하여 현수는 선생님이 주신 N개의 문제를
풀려고 합니다. 각 문제는 그것을 풀었을 때 얻는 점수와 푸는데 걸리는 시간이 주어지게 됩
니다. 제한시간 M안에 N개의 문제 중 최대점수를 얻을 수 있도록 해야 합니다. (해당문제는
해당시간이 걸리면 푸는 걸로 간주한다, 한 유형당 한개만 풀 수 있습니다.)
 ▣입력설명
첫 번째 줄에 문제의 개수N(1<=N<=50)과 제한 시간 M(10<=M<=300)이 주어집니다.
두 번째 줄부터 N줄에 걸쳐 문제를 풀었을 때의 점수와 푸는데 걸리는 시간이 주어집니다.
 ▣출력설명
첫 번째 줄에 제한 시간안에 얻을 수 있는 최대 점수를 출력합니다.

▣입력예제 1
5 20
10 5
25 12
15 8
6 3
7 4

▣출력예제 1
41


2 10
10 6
10 3

*/
public class 최대점수구하기_6 {

    static class Quiz {
        int point;
        int time;

        public Quiz(int point, int time) {
            this.point = point;
            this.time = time;
        }
    }

    static int timeout;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        timeout =  scanner.nextInt();

        Quiz[] quizzes = new Quiz[n];
        for (int i = 0; i < n; i++) {
            quizzes[i] = new Quiz(scanner.nextInt(), scanner.nextInt());
        }


        int score = dfs(quizzes, 0, 0, 0);
        System.out.println(score);

    }

    static int dfs(Quiz[] quizzes, int index, int min, int score) {

        if (index == quizzes.length) return score;


        // 풀때
        int scoreY = 0;
        Quiz quiz = quizzes[index];
        int dTime = quiz.time + min;
        int dScore = quiz.point + score;
        if (dTime <= timeout) {
            scoreY = dfs(quizzes, index + 1, dTime, dScore);
        }

        // 안풀때 점수
        int scoreN = dfs(quizzes, index + 1, min, score);
        
        return Math.max(scoreY, scoreN);
    }


}
