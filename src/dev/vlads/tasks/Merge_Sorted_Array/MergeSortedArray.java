package dev.vlads.tasks.Merge_Sorted_Array;

// https://leetcode.com/problems/merge-sorted-array/

public class MergeSortedArray {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = new int[] {1,2,3,0,0,0};
        solution.merge(
                arr,
                3,
                new int[] {2,5,6},
                3
        );
        for (int element : arr) System.out.println(element);
    }
}

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // merge
        for (int num2I = 0; num2I < n; num2I++) {
            nums1[m + num2I] = nums2[num2I];
        }
        // sort
        int size = m + n;
        for (int j = size; j > 0; j--) {
            for (int i = 0; i < j-1; i++) {
                if (nums1[i] > nums1[i+1]) {
                    int t = nums1[i];
                    nums1[i] = nums1[i+1];
                    nums1[i+1] = t;
                }
            }
        }
    }
}
