package dev.vlads.tasks.Swap_Nodes_in_Pairs;

/*
https://leetcode.com/problems/swap-nodes-in-pairs/
Given a linked list, swap every two adjacent nodes and return its head. You must solve the problem without modifying the values in the list's nodes (i.e., only nodes themselves may be changed.)
*/

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class SwapNodesinPairs {
    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode n = new ListNode(1,
                new ListNode(2,
                        new ListNode(3,
                                new ListNode(4, null)))
                );
        solution.swapPairs(n);
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
    public ListNode swapPairs(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return head;
        ArrayList<ListNode> list = new ArrayList<>();
        ListNode $temp = head;
        while ($temp != null) {
            list.add($temp);
            $temp = $temp.next;
        }

        int lastI = 0;
        ListNode lastSwapped = null;
        for (int i = 0; i+1 < list.size(); i=i+2) {
            ListNode left = list.get(i);
            ListNode right = list.get(i+1);
            right.next = left;
            left.next = null;
            if (lastSwapped == null) {
                head = right;
            }
            if (lastSwapped != null) {
                lastSwapped.next = right;
            }
            lastSwapped = left;
            lastI = i+1;
        }


        for (int i = lastI+1; i < list.size(); i++) {
            lastSwapped.next = list.get(i);
            lastSwapped = lastSwapped.next;
        }

        return head;
    }
}