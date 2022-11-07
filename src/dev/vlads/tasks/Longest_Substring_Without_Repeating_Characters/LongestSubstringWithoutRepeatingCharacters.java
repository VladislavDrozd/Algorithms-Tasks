package dev.vlads.tasks.Longest_Substring_Without_Repeating_Characters;

/*
https://leetcode.com/problems/longest-substring-without-repeating-characters/
Given a string s, find the length of the longest substring without repeating characters.
Example 1:
Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
*/

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        //String input = "pwwkew";
        String input = "aab";
        int expected = 3;
        Solution solution = new Solution();
        int output = solution.lengthOfLongestSubstring(input);
        System.out.println(expected == output);
    }
}

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null) return 0;
        if (s.equals("")) return 0;
        if (s.length() == 1) return 1;

        StringBuilder SB_max = new StringBuilder();
        StringBuilder SB_current = new StringBuilder();
        String[] arr = s.split("");

        for (int i = 0; i < arr.length; i++) {
            String letter = arr[i];
            if (SB_current.toString().contains(letter)) {
                if (SB_current.length() > SB_max.length()) {
                    SB_max = SB_current;
                }
                i = i - SB_current.length();
                SB_current = new StringBuilder();
            } else {
                SB_current.append(letter);
            }
        }

        return Math.max(SB_max.length(), SB_current.length());
    }
}