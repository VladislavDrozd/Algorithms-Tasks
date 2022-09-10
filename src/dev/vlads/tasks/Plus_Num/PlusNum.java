package dev.vlads.tasks.Plus_Num;

/* https://leetcode.com/problems/plus-one/ MODIFIED BY MYSELF
66. Plus One
Add to List
Share
You are given a large integer represented as an integer array digits, where each digits[i] is the ith digit of the integer. The digits are ordered from most significant to least significant in left-to-right order. The large integer does not contain any leading 0's.

Increment the large integer by one and return the resulting array of digits.

Example 1:

Input: digits = [1,2,3]
Output: [1,2,4]
Explanation: The array represents the integer 123.
Incrementing by one gives 123 + 1 = 124.
Thus, the result should be [1,2,4].
*/
public class PlusNum {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] input = {4,6,8,9};
        int add = 491;
        for (int $ : solution.plusNum(add, input))
            System.out.print($);
    }
}

class Solution {
    public int[] plusNum(int add, int[] digits) {
        for (int i = digits.length-1; i >= 0; i--) {
            int current = digits[i] + add;
            add = cutNumber(current);
            digits[i] = getLast(current);
        }
        return digits;
    }
    private int cutNumber(int n) {
        if (n < 10) return 0;
        String srep = String.valueOf(n);
        String newSrep = srep.substring(0, srep.length()-1);
        return Integer.decode(newSrep);
    }
    private int getLast(int n) {
        String srep = String.valueOf(n);
        return Integer.decode(String.valueOf(srep.charAt(srep.length()-1)));
    }
}