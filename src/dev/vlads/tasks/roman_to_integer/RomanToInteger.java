package dev.vlads.tasks.roman_to_integer;

import java.util.*;

/* https://leetcode.com/problems/roman-to-integer/
13. Roman to Integer

Share
Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
For example, 2 is written as II in Roman numeral, just two ones added together. 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.

Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:

I can be placed before V (5) and X (10) to make 4 and 9.
X can be placed before L (50) and C (100) to make 40 and 90.
C can be placed before D (500) and M (1000) to make 400 and 900.
Given a roman numeral, convert it to an integer.



Example 1:

Input: s = "III"
Output: 3
Explanation: III = 3.
Example 2:

Input: s = "LVIII"
Output: 58
Explanation: L = 50, V= 5, III = 3.
Example 3:

Input: s = "MCMXCIV"
Output: 1994
Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.


Constraints:

1 <= s.length <= 15
s contains only the characters ('I', 'V', 'X', 'L', 'C', 'D', 'M').
It is guaranteed that s is a valid roman numeral in the range [1, 3999].
*/

public class RomanToInteger {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(
                solution.romanToInt("MCMXCIV")
                //solution.romanToInt("LVIII")
                //solution.romanToInt("IV")
        );
    }
}

class Solution {
    Map<String, Integer> vocabulary = new HashMap<>();
    private void initVocabulary() {
        vocabulary.put("I", 1);
        vocabulary.put("V", 5);
        vocabulary.put("X", 10);
        vocabulary.put("L", 50);
        vocabulary.put("C", 100);
        vocabulary.put("D", 500);
        vocabulary.put("M", 1000);
        vocabulary.put("IV", 4);
        vocabulary.put("IX", 9);
        vocabulary.put("XL", 40);
        vocabulary.put("XC", 90);
        vocabulary.put("CD", 400);
        vocabulary.put("CM", 900);
    }
    private int count(Stack<String> stack) {
        int counter = 0;
        while (!stack.empty()) {
            String _s = stack.pop();
            Integer cost = vocabulary.get(_s);
            counter = counter + cost;
        }
        return counter;
    }
    public int romanToInt(String s) {
        initVocabulary();
        String[] arr = s.split("");
        Stack<String> stack = new Stack<>();

        for(int i = arr.length-1; i >= 0;) {
            String t = arr[i];
            if (i != 0) {
                t = arr[i-1] + arr[i];
            }
            if (vocabulary.containsKey(t)) {
                stack.add(t);
                i = i - 2;
            } else {
                stack.add(arr[i]);
                i = i - 1;
            }
        }
        return count(stack);
    }
}
