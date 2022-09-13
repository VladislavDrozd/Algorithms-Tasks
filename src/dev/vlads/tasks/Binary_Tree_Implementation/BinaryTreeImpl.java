package dev.vlads.tasks.Binary_Tree_Implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BinaryTreeImpl {

    private final Node head;

    public BinaryTreeImpl(int val) {
        this.head = new Node(val);
    }

    public Node getHead() {
        return head;
    }

    public void addNode(int val) {
        Node newNode = new Node(val);
        Node currentNode = head;
        while (currentNode != null) {
            if (newNode.value >= currentNode.value) {
                if (currentNode.right == null) {
                    currentNode.right = newNode;
                    currentNode = null;
                } else {
                    currentNode = currentNode.right;
                }
            } else {
                if (currentNode.left == null) {
                    currentNode.left = newNode;
                    currentNode = null;
                } else {
                    currentNode = currentNode.left;
                }
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder SB = new StringBuilder();
        for (Node node : getBinaryTreeNodesAsList()) {
            SB.append(node.value).append(",");
        }
        SB.deleteCharAt(SB.length()-1);
        return SB.toString();
    }

    public List<Node> getBinaryTreeNodesAsList() {
        List<Node> list = new ArrayList<>();
        runOnNodes(head, list);
        return list;
    }

    private void runOnNodes(Node node, List<Node> list) {
        list.add(node);
        if (node.left != null) {
            runOnNodes(node.left, list);
        } else {
            if (node.right != null) {
                runOnNodes(node.right, list);
            }
            return;
        }

        if (node.right != null) {
            runOnNodes(node.right, list);
        } else {
            return;
        }
    }

    @Override
    public boolean equals(Object o) {
        // compare string representations of binary tree
        String thisObj = this.toString();
        String thatObj = o.toString();
        return thisObj.equals(thatObj);
    }

    @Override
    public int hashCode() {
        return Objects.hash(head);
    }

    static class Node {
        private int value;
        private Node right;
        private Node left;
        public Node(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }
    }

}
