package lecture.cordingTest.ch7;

import lombok.RequiredArgsConstructor;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class Tree말단노드까지가장짧은경로_9 {

    @RequiredArgsConstructor
    static class Node {
        final int value;
        Node left;
        Node right;
    }

    public static void main(String[] args) {

        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);

        node1.left = node2;
        node1.right = node3;
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);

        node2.left = node4;
        node3.right = node5;
        node4.left = node6;

        System.out.println(solution(node1));


    }

    private static int solution(Node node) {
        Queue<Node> Q = new ArrayDeque<>();
        Q.offer(node);

        int l = 0;
        while (!Q.isEmpty()) {

            int len = Q.size();
            for (int i = 0; i < len; i++) {
                Node currentNode = Q.poll();
                if (currentNode.left == null && currentNode.right == null) {
                    return l;
                }
                if (currentNode.left != null) Q.offer(currentNode.left);
                if (currentNode.right != null) Q.offer(currentNode.right);
            }
            l++;
        }
        return -1;
    }
}
