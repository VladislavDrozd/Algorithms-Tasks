package dev.vlads.Merge_Two_Sorted_Lists;


public class MergeTwoSortedLists {
    public static void main(String[] args) {
        //Input: list1 = [1,2,4], list2 = [1,3,4]
        //Output: [1,1,2,3,4,4]
        ListNode listNode1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(8, new ListNode(9, null)))))));
        ListNode listNode2 = new ListNode(6, new ListNode(7, new ListNode(7, new ListNode(10, null))));
        Solution solution = new Solution();
        solution.printNode(
                solution.mergeTwoLists(listNode1, listNode2)
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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // figure out head of new list
        ListNode head;
        if(list1.val <= list2.val) {
            head = list1;
            list1 = list1.next;
        } else {
            head = list2;
            list2 = list2.next;
        }

        ListNode temp = head;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                temp.next = list1;
                list1 = list1.next;
            } else {
                temp.next = list2;
                list2 = list2.next;
            }
            temp = temp.next;
        }
        if (list1 == null) {
            temp.next = list2;
        } else {
            temp.next = list1;
        }
        return head;
    }

    public void printNode(ListNode node) {
        if (node == null) return;
        System.out.println(node.val);
        printNode(node.next);
    }
 }
