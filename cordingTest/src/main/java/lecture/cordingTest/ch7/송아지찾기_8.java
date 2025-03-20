package lecture.cordingTest.ch7;

import lombok.RequiredArgsConstructor;

import java.util.*;

/**
 * 13 35
 * 6
 *
 * 3 4356
 *
 * 873
 */
public class 송아지찾기_8 {


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int first = scanner.nextInt();
        int n = scanner.nextInt();
        System.out.println(bfs(first, n));
    }

    private static int bfs(int first, int n) {
        Queue<Integer> q = new LinkedList<>();
        Set<Integer> history = new HashSet<>();
        q.offer(first);
        history.add(first);
        int level = 0;
        while (!q.isEmpty()) {
            int len = q.size();
            for (int i = 0; i < len; i++) {
                int currentNode = q.poll();
                if (currentNode == n) {
                    return level;
                }
                extracted(history, currentNode + 1, q, currentNode);
                extracted(history, currentNode - 1, q, currentNode);
                extracted(history, currentNode + 5, q, currentNode);
            }
            level++;
        }
        return -1;
    }

    private static void extracted(Set<Integer> history, int check, Queue<Integer> q, int currentNode1) {
        if (!history.contains(check)) {
            history.add(check);
            q.offer(check);
        }
    }
}
