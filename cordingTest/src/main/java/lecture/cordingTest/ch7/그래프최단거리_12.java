package lecture.cordingTest.ch7;

import java.util.*;

/*
 6 9
 1 3
 1 4
 2 1
 2 5
 3 4
 4 5
 4 6
 6 2
 6 5


 2 : 3
 3 : 1
 4 : 1
 5 : 2
 6 : 2
 */
public class 그래프최단거리_12 {

    private static List<Integer>[] graph;
    private static int[] distance;
    private static int n;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        int trunk = scanner.nextInt();

        graph = new ArrayList[n + 1];//new int[n+1][n+1];
        distance  = new int[n+1];

        for (int i = 0; i < n + 1; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 1; i <= trunk; i++) {
            List<Integer> list = graph[scanner.nextInt()];
            list.add(scanner.nextInt());
        }
        distance[1] = 0;
        bfs(1);

        for (int i = 1; i <= n; i++) {
            System.out.println(i + " = " + distance[i]);
        }
    }

//    Queue<이진트리순회_넒이우선탐색_6.Node> q = new LinkedList<>();
//        q.offer(node);
//        while (!q.isEmpty()) {
//        int len = q.size();
//        for (int i = 0; i < len; i++) {
//            이진트리순회_넒이우선탐색_6.Node currentNode = q.poll();
//            System.out.print(currentNode.value + " ");
//            if(currentNode.left != null) q.offer(currentNode.left);
//            if(currentNode.right != null) q.offer(currentNode.right);
//        }
//    }
    private static void bfs(int node) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                Integer currentNode = queue.poll();
                for (Integer integer : graph[currentNode]) {
                    if (distance[integer] == 0 && integer != node) {
                        distance[integer] = distance[currentNode] + 1;
                        queue.add(integer);
                    }
                }
            }
        }
    }

}
