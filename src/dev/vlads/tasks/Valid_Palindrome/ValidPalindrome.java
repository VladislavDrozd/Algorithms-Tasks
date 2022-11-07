package dev.vlads.tasks.Valid_Palindrome;

/*
https://leetcode.com/problems/valid-palindrome/
A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all
non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.
Given a string s, return true if it is a palindrome, or false otherwise.
Example 1:
Input: s = "A man, a plan, a canal: Panama"
Output: true
Explanation: "amanaplanacanalpanama" is a palindrome.
*/

public class ValidPalindrome {
    public static void main(String[] args) {
        String input = "A man, a plan, a canal: Panama";
        boolean expected = true;
        Solution solution = new Solution();
        boolean actual = solution.isPalindrome(input);
        System.out.println( expected == actual );
    }
}

class Solution {
    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0 || s.length() == 1) return true;
        String initial = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        String backwards = new StringBuilder(s).reverse().toString().replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        return initial.equals(backwards);
    }
}