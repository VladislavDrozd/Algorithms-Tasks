package dev.vlads.tasks.Largest_3_Same_Digit_Number_in_String;

/*
https://leetcode.com/problems/largest-3-same-digit-number-in-string/
You are given a string num representing a large integer. An integer is good if it meets the following conditions:
It is a substring of num with length 3.
It consists of only one unique digit.
Return the maximum good integer as a string or an empty string "" if no such integer exists.
Note:
A substring is a contiguous sequence of characters within a string.
There may be leading zeroes in num or a good integer.

Input: num = "6777133339"
Output: "777"
Explanation: There are two distinct good integers: "777" and "333".
"777" is the largest, so we return "777".
*/

import java.util.Arrays;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        String num = "6777133339";
        Solution solution = new Solution();
        System.out.println(
                solution.largestGoodInteger(num)
        );
    }
}

class Solution {
    public String largestGoodInteger(String num) {
        TreeSet<String> set = new TreeSet<>();
        int counter = 1;
        String currentLetter = null;
        for (String s : num.split("")) {
            if (currentLetter == null) {
                currentLetter = s;
            } else {
                if (currentLetter.equals(s)) {
                    counter++;
                    if (counter == 3) {
                        set.add(s);
                        counter = 1;
                        currentLetter = null;
                    }
                } else {
                    counter = 1;
                    currentLetter = s;
                }
            }
        }
        if (set.size() == 0) {
            return "";
        } else {
            String res = set.last();
            return res + res + res;
        }
    }
}