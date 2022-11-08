package dev.vlads.tasks.Next_Permutation;

/*
https://leetcode.com/problems/next-permutation/
A permutation of an array of integers is an arrangement of its members into a sequence or linear order.
For example, for arr = [1,2,3], the following are all the permutations of arr: [1,2,3], [1,3,2], [2, 1, 3], [2, 3, 1], [3,1,2], [3,2,1].
Example 1:
Input: nums = [1,2,3]
Output: [1,3,2]
*/

import java.util.Arrays;
import java.util.Collections;

public class NextPermutation {
    public static void main(String[] args) {
        //int[] input = {1,2,3,};
        //int[] expected = {1,3,2};
        int[] input = {3,2,1};
        int[] expected = {1,2,3};
        Solution solution = new Solution();
        solution.nextPermutation(input);
        System.out.println(Arrays.equals(input, expected));
    }
}

class Solution {
    public void nextPermutation(int[] nums) {
        if (nums.length == 1) return;
        for (int leftI = nums.length-2; leftI > 0; leftI--) {
            int min = nums[nums.length-1];
            int minI = nums.length-1;
            for (int rightI = nums.length-1; leftI > rightI; rightI--) {
                if (nums[rightI] < min && nums[rightI] > nums[leftI]) {
                    min = nums[rightI];
                    minI = rightI;
                }
            }
            if (min > nums[leftI]) {
                swap(nums, leftI, minI);
                return;
            }
        }

        reverseOrder(nums);
    }
    private void swap(int[] nums, int leftI, int rightI) {
        int temp = nums[leftI];
        nums[leftI] = nums[rightI];
        nums[rightI] = temp;
    }

    private void reverseOrder(int[] nums) {
        for (int leftI = 0, rightI = nums.length-1; leftI < rightI; leftI++, rightI--) {
            swap(nums, leftI, rightI);
        }
    }
}