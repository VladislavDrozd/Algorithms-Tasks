package dev.vlads.tasks.Binary_Tree_Implementation;

public class Main1 {
    public static void main(String[] args) {
        BinaryTreeImpl BTI = new BinaryTreeImpl(5);
        BTI.addNode(1);
        BTI.addNode(-2);
        BTI.addNode(7);
        BTI.addNode(6);
        BTI.addNode(8);
        System.out.println(BTI);
    }
}
