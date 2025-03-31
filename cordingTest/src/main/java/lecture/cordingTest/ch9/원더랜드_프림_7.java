package lecture.cordingTest.ch9;

import java.util.*;

/*
원더랜드는 모든 도시를 서로 연결하면서 최소의 유지비용이 들도록 도로를 선택하고 나머지
도로는 폐쇄하려고 한다.

▣입력예제 1
9 12
1 2 12
1 9 25
2 3 10
2 8 17
2 9 8
3 4 18
3 7 55
4 5 44
5 6 60
5 7 38
7 8 35
8 9 15

▣출력예제 1
196

 */
public class 원더랜드_프림_7 {


    static class Node implements Comparable<Node> {
        int to;
        int coast;

        public Node(int to, int coast) {
            this.to = to;
            this.coast = coast;
        }

        @Override
        public int compareTo(Node o) {
            return this.coast - o.coast;
        }
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int count = scanner.nextInt();

        boolean[] visited = new boolean[n + 1];


        List<List<Node>> nodes = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            nodes.add(new ArrayList<>());
        }
        for (int i = 0; i < count; i++) {
            int from = scanner.nextInt();
            int to = scanner.nextInt();
            int coast = scanner.nextInt();
            nodes.get(from).add(new Node(to, coast));
            nodes.get(to).add(new Node(from, coast));
        }

        int ret = solution(nodes, visited);
        System.out.println(ret);
    }

    private static int solution(List<List<Node>> nodes,  boolean[] visited) {

        int coast = 0;
        Queue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(1, 0));


        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if(visited[node.to]) continue;

            visited[node.to] = true;
            coast += node.coast;
            for(Node next : nodes.get(node.to)) {
                if(!visited[next.to]) queue.add(next);
            }
        }
        return coast;
    }



}
