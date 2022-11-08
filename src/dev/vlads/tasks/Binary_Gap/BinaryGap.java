package dev.vlads.tasks.Binary_Gap;

import java.util.ArrayList;

public class BinaryGap {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int result = solution.solution2(5);
        System.out.println(result);
    }
}

class Solution {
    public int solution1(int N) {
        String binary = Integer.toBinaryString(N);
        int max = 0;
        int counter = 0;
        for (int i = 0; i < binary.length(); i++) {
            char c = binary.charAt(i);
            if (c == '1') {
                if (counter > 0) {
                    max = Math.max(max, counter);
                    counter = 0;
                }
            } else {
                counter++;
            }
        }
        return max;
    }

    public int solution2(int N) {
        String init = Integer.toBinaryString(N);
        String[] arr = init.split("1");
        int max = 0;
        for (
             int i = init.startsWith("0") ? 1 : 0,
             end = init.endsWith("0") ? arr.length-1 : arr.length;
             i < end;
             i++
        ) {
            max = Math.max(max, arr[i].length());
        }
        return max;
    }
}