package dev.vlads.tasks.Two_Sum;

/*
Two Sum
https://leetcode.com/problems/two-sum/
Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
You may assume that each input would have exactly one solution, and you may not use the same element twice.
You can return the answer in any order.
Example 1:
Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
*/

public class TwoSum {
    public static void main(String[] args) {

    }
}

class Solution {
    public int[] twoSum(int[] nums, int target) {
        for (int leftI = 0; leftI < nums.length-1; leftI++) {
            for (int rightI = leftI+1; rightI < nums.length; rightI++) {
                if (nums[leftI] + nums[rightI] == target) {
                    return new int[] {leftI, rightI};
                }
            }
        }
        return new int[0];
    }
}