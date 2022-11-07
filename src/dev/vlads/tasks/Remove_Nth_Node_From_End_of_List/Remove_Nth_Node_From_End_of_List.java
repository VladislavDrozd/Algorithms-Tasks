package dev.vlads.tasks.Remove_Nth_Node_From_End_of_List;

/*
https://leetcode.com/problems/remove-nth-node-from-end-of-list/
Given the head of a linked list, remove the nth node from the end of the list and return its head
*/

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class Remove_Nth_Node_From_End_of_List {
    public static void main(String[] args) {

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
    public ListNode removeNthFromEnd(ListNode head, int n) {

        // case 1
        if (head == null) return null;

        // case 2
        if (n == 0) return head;

        ArrayList<ListNode> list = new ArrayList<>();
        ListNode node = head;
        while (node != null) {
            list.add(node);
            node = node.next;
        }

        // case 3
        if (list.size() == 1 && n == 1) return null;

        int removeI = list.size() - n;

        // case 4
        if (removeI == 0) {
            return list.get(1);
        }

        // case 5
        if (removeI == list.size()-1) {
            list.get(removeI-1).next = null;
            return head;
        }

        // case 6
        list.get(removeI-1).next = list.get(removeI+1);
        return head;
    }
}