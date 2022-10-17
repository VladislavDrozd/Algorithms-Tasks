package dev.vlads.tasks.IntersectionOfTwoLinkedLists;

/*
https://leetcode.com/problems/intersection-of-two-linked-lists/
Given the heads of two singly linked-lists headA and headB, return the node at which the two lists intersect.
If the two linked lists have no intersection at all, return null.
*/

import java.util.LinkedHashSet;

public class IntersectionOfTwoLinkedLists {
    public static void main(String[] args) {

    }
}

class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // use LinkedHashSet to save insertion order and then get first intersection occurrence
        LinkedHashSet<ListNode> nodesListA = new LinkedHashSet<>();
        LinkedHashSet<ListNode> nodesListB = new LinkedHashSet<>();

        while (headA != null) {
            nodesListA.add(headA);
            headA = headA.next;
        }

        while (headB != null) {
            nodesListB.add(headB);
            headB = headB.next;
        }

        LinkedHashSet<ListNode> intersection = new LinkedHashSet<>(nodesListA);
        intersection.retainAll(nodesListB);

        return intersection.stream().findFirst().orElse(null);
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