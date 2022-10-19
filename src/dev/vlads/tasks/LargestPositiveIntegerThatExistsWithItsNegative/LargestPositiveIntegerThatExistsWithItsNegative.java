package dev.vlads.tasks.LargestPositiveIntegerThatExistsWithItsNegative;

/*
https://leetcode.com/problems/largest-positive-integer-that-exists-with-its-negative/
Given an integer array nums that does not contain any zeros, find the largest positive integer k such that -k also exists in the array.
Return the positive integer k. If there is no such integer, return -1.
*/

import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class LargestPositiveIntegerThatExistsWithItsNegative {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int r = solution.findMaxK(new int[]{-10,1,5,-3,3});
        System.out.println(r);
    }
}

class Solution {
    public int findMaxK(int[] nums) {
        TreeSet<Integer> pos = Arrays.stream(nums).boxed()
                .filter(n -> n > 0)
                .collect(Collectors.toCollection(() -> new TreeSet<Integer>(Comparator.reverseOrder())));

        TreeSet<Integer> neg = Arrays.stream(nums).boxed()
                .filter(n -> n < 0)
                .collect(Collectors.toCollection(() -> new TreeSet<Integer>(Comparator.reverseOrder())));

        for (Integer p : pos) {
            if (neg.contains(p * -1)) return p;
        }

        return -1;
    }
}