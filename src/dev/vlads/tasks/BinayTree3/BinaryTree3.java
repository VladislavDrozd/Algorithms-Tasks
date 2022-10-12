package dev.vlads.tasks.BinayTree3;

public class BinaryTree3 {
    public static void main(String[] args) {

    }
}

class BinaryTree3Class {
    Node head;

    public BinaryTree3Class(Node head) {
        this.head = head;
    }

    static class Node {
        int value;
        Node left, right;
        public Node(int value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }


}