package dev.vlads.tasks.Single_Number;

/*

Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.

You must implement a solution with a linear runtime complexity and use only constant extra space.



Example 1:

Input: nums = [2,2,1]
Output: 1
Example 2:

Input: nums = [4,1,2,1,2]
Output: 4
Example 3:

Input: nums = [1]
Output: 1

*/

public class SingleNumber {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(
                solution.singleNumber(new int[] {4,1,2,1,2})
                //solution.singleNumber(new int[] {2,2,1})
        );
    }
}
class Solution {
    public int singleNumber(int[] nums) {
        int result = 0;
        for(int i : nums) {
            result = result ^ i;
            System.out.println(result);
            //result ^= i;
        }
        return result;
    }
}
/*
class Solution {
    public int singleNumber(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        for (int candidateI = 0; candidateI < nums.length; candidateI++) {
            int candidate = nums[candidateI];
            for (int i = 0; i < nums.length; i++) {
                if (i == candidateI) {
                    if (candidateI == nums.length - 1) {
                        return candidate;
                    } else {
                        continue;
                    }
                }
                if (candidate == nums[i]) break;
                if (i == nums.length-1) {
                    if (candidate != nums[i]) return candidate;
                }
            }
        }
        return 0;
    }
}
*/
