package dev.vlads.tasks.Remove_Duplicates_from_Sorted_List;

public class RemoveDuplicatesFromSortedList {
    public static void main(String[] args) {
        ListNode testNode = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(3, new ListNode(3, new ListNode(4, new ListNode(5, null)))))));
        Solution solution = new Solution();
        solution.printNode(
                solution.deleteDuplicates(testNode)
        );
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public void printNode(ListNode node) {
        if (node == null) return;
        System.out.println(node.val);
        printNode(node.next);
    }
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return  null;
        ListNode node = head.next;
        ListNode prevNode = head;
        while (node != null) {
            if (node.val == prevNode.val) {
                prevNode.next = node.next;
                node = node.next;
            } else {
                prevNode = node;
                node = node.next;
            }
        }
        return head;
    }
}
