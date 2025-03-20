package lecture.cordingTest.ch7;

import lombok.RequiredArgsConstructor;

import java.util.LinkedList;
import java.util.Queue;

public class 이진트리순회_넒이우선탐색_6 {

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
        node2.left = new Node(4);
        node2.right = new Node(5);
        node3.left = new Node(6);
        node3.right = new Node(7);

        bfs(node1);
    }

    private static void bfs(Node node) {
        Queue<Node> q = new LinkedList<>();
        q.offer(node);
        while (!q.isEmpty()) {
            int len = q.size();
            for (int i = 0; i < len; i++) {
                Node currentNode = q.poll();
                System.out.print(currentNode.value + " ");
                if(currentNode.left != null) q.offer(currentNode.left);
                if(currentNode.right != null) q.offer(currentNode.right);
            }
        }
    }


}
