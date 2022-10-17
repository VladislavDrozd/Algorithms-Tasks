package dev.vlads.tasks.Linked_List_Cycle;

import java.util.HashSet;
// https://leetcode.com/problems/linked-list-cycle/

/*
Given head, the head of a linked list, determine if the linked list has a cycle in it.
There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to. Note that pos is not passed as a parameter.
Return true if there is a cycle in the linked list. Otherwise, return false.
*/
public class LinkedListCycle {
    public static void main(String[] args) {

    }
}


class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}
class Solution {
    public boolean hasCycle(ListNode head) {
        HashSet<ListNode> set = new HashSet<>(20, 0.9f);
        while (head != null) {
            if (!set.add(head)) return true;
            head = head.next;
        }
        return false;
    }
}