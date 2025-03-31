package lecture.cordingTest.ch9;

import java.util.Arrays;
import java.util.Scanner;

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
public class 원더랜드_크루스칼_7 {

    static class Node implements Comparable<Node> {
        int from;
        int to;
        int coast;

        public Node(int from, int to, int coast) {
            this.from = from;
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

        int[] arr = new int[n + 1];
        for (int i = 1; i < arr.length; i++) {
            arr[i] = i;
        }

        Node[] nodes = new Node[count];
        for (int i = 0; i < count; i++) {
            nodes[i] = new Node(scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
        }

        int ret = solution(nodes, arr);
        System.out.println(ret);
    }

    private static int solution(Node[] nodes, int[] arr) {
        Arrays.sort(nodes);
        int coast = 0;

        for (Node node : nodes) {
            int fromRoot = find(arr, node.from);
            int toRoot = find(arr, node.to);
            if (fromRoot != toRoot) {
                coast += node.coast;
                arr[toRoot] = fromRoot;
            }
        }
        return coast;
    }

    private static int find(int[] arr, int index) {
        if(arr[index] == index) return index;
        return find(arr, arr[index]);
    }

}
