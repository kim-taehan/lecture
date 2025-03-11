package lecture.cordingTest.ch6Sort;

import java.util.Arrays;
import java.util.Scanner;

/*
N개의 평면상의 좌표(x, y)가 주어지면 모든 좌표를 오름차순으로 정렬하는 프로그램을 작성하세요.
정렬기준은 먼저 x값의 의해서 정렬하고, x값이 같을 경우 y값에 의해 정렬합니다.

5
2 7
1 3
1 2
2 5
3 6


1 2
1 3
2 5
2 7
3 6
 */
public class 좌표정렬_7 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        Point[] points = new Point[size];

        for (int i = 0; i < size; i++) {
            points[i] = new Point(scanner.nextInt(), scanner.nextInt());
        }

        Point[] solution = solution(size, points);
        for (Point point : solution) {
            System.out.println(point.x + " " + point.y);
        }
    }

    private static Point[] solution(int size, Point[] points) {
        Arrays.sort(points);
        return points;
    }

    static class Point implements Comparable<Point> {
        Integer x;
        Integer y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point o) {
            int ret = x.compareTo(o.x);
            if (ret == 0) {
                return y.compareTo(o.y);
            }
            return ret;
        }
    }

}
