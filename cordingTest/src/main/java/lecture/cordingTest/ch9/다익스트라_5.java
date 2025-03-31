package lecture.cordingTest.ch9;

import java.util.*;

/*
아래의 가중치 방향그래프에서 1번 정점에서 모든 정점으로의 최소 거리비용을 출력하는 프로
그램을 작성하세요. (경로가 없으면 Impossible를 출력한다)

6 9
1 2 12
1 3 4
2 1 2
2 3 5
2 5 5
3 4 5
4 2 2
4 5 5
6 4 5

2 : 11
3 : 4
4 : 9
5 : 14
6 : impossible

 */
public class 다익스트라_5 {

    static class Line implements Comparable<Line> {
        int node;
        int distance;

        public Line(int node, int distance) {
            this.node = node;
            this.distance = distance;
        }
        @Override
        public int compareTo(Line o) {
            return this.distance - o.distance ;
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int count = scanner.nextInt();

        int[] dis = new int[n+1];
        dis[1] = 0;
        for (int i = 2; i < dis.length; i++) {
            dis[i] = Integer.MAX_VALUE;
        }

        Map<Integer, List<Line>> listMap = new HashMap<>();

        for (int i = 1; i <= count; i++) {
            int start = scanner.nextInt();
            int end = scanner.nextInt();
            int distance = scanner.nextInt();

            List<Line> lines = listMap.getOrDefault(start, new ArrayList<>());
            lines.add(new Line(end, distance));
            listMap.put(start, lines);
        }

        solution(dis, listMap);

        for (int i = 2; i <= n; i++) {
            System.out.println(i + " = " + dis[i]);
        }
    }

    private static void solution(int[] dis, Map<Integer, List<Line>> listMap) {

        Queue<Line> queue = new PriorityQueue<>();

        queue.offer(new Line(1, 0));

        while (!queue.isEmpty()) {
            Line line = queue.poll();

            if (listMap.containsKey(line.node)) {
                for (Line line1 : listMap.get(line.node)) {
                    int distance = Math.min(dis[line1.node], line.distance + line1.distance);
                    if (distance < dis[line1.node]) {
                        queue.add(new Line(line1.node, distance));
                        dis[line1.node] = distance;
                    }

                }
            }
        }
    }
}
