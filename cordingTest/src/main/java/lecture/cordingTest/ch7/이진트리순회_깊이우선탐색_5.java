package lecture.cordingTest.ch7;

import lombok.RequiredArgsConstructor;

public class 이진트리순회_깊이우선탐색_5 {

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

        System.out.println("전위순회");
        전위순회(node1);
        System.out.println("\n중위순회");
        중위순회(node1);
        System.out.println("\n후위순회");
        후위순회(node1);
    }

    private static void 전위순회(Node node) {
        System.out.print(node.value + " ");
        if(node.left != null) 전위순회(node.left);
        if(node.right != null) 전위순회(node.right);
    }

    private static void 중위순회(Node node) {
        if(node.left != null) 중위순회(node.left);
        System.out.print(node.value + " ");
        if(node.right != null) 중위순회(node.right);
    }

    private static void 후위순회(Node node) {
        if(node.left != null) 후위순회(node.left);
        if(node.right != null) 후위순회(node.right);
        System.out.print(node.value + " ");
    }
}
