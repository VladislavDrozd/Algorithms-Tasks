package dev.vlads.tasks.Valid_Parentheses;

import java.util.Stack;

/* https://leetcode.com/problems/valid-parentheses/
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Every close bracket has a corresponding open bracket of the same type.


Example 1:

Input: s = "()"
Output: true
Example 2:

Input: s = "()[]{}"
Output: true
Example 3:

Input: s = "(]"
Output: false
*/
public class ValidParentheses {
    public static void main(String[] args) {
        //String input = "()[]{}"; // expected TRUE
        //String input = "{[]}"; // expected TRUE
        String input = "(){}}{"; // expected TRUE
        Solution solution = new Solution();
        System.out.println(solution.isValid(input));
    }
}

class Solution {
    public boolean isValid(String s) {
        String[] arr = s.split("");
        if (arr.length == 0 || equalsCloseBracket(arr[0])) return false;
        Stack<String> openStack = new Stack<>();
        for (String value : arr) {
            if (equalsOpenBracket(value)) {
                openStack.push(value);
            } else {
                if (openStack.isEmpty() || !value.equals(findCloseBracket(openStack.pop()))) return false;
            }
        }
        return openStack.isEmpty();
    }
    private boolean equalsOpenBracket(String s) {
        return s.equals("(") || s.equals("{") || s.equals("[");
    }
    private boolean equalsCloseBracket(String s) {
        return s.equals(")") || s.equals("}") || s.equals("]");
    }
    private String findCloseBracket(String s) {
        if (s.equals("(")) return ")";
        if (s.equals("{")) return "}";
        if (s.equals("[")) return "]";
        throw new IllegalArgumentException(s+" is illegal argument");
    }
}