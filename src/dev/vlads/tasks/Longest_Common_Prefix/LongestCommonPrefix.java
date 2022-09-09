package dev.vlads.tasks.Longest_Common_Prefix;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        //String[] input = {"flower","flow","flight"};
        String[] input = {"","b"};
        Solution solution = new Solution();
        String result = solution.longestCommonPrefix(input);
        System.out.println(result);
    }
}

class Solution {
    public String longestCommonPrefix(String[] strs) {
        String shortest = strs[0];
        for (String $ : strs) if (shortest.length() > $.length()) shortest = $;
        StringBuilder prefix = new StringBuilder("");
        String currentLetter;
        for (int i = 0; i < shortest.length(); i++) {
            currentLetter = String.valueOf(shortest.charAt(i));
            for (String $ : strs) if ((i >= $.length()) || (!String.valueOf($.charAt(i)).equals(currentLetter))) return prefix.toString();
            prefix.append(currentLetter);
        }
        return prefix.toString();
    }
}
