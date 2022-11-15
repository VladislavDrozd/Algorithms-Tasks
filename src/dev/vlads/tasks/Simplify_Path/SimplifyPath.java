package dev.vlads.tasks.Simplify_Path;

/*
https://leetcode.com/problems/simplify-path/
Given a string path, which is an absolute path (starting with a slash '/') to a file or directory in a Unix-style file system, convert it to the simplified canonical path.
In a Unix-style file system, a period '.' refers to the current directory, a double period '..' refers to the directory up a level, and any multiple consecutive slashes (i.e. '//') are treated as a single slash '/'. For this problem, any other format of periods such as '...' are treated as file/directory names.
The canonical path should have the following format:
The path starts with a single slash '/'.
Any two directories are separated by a single slash '/'.
The path does not end with a trailing '/'.
The path only contains the directories on the path from the root directory to the target file or directory (i.e., no period '.' or double period '..')
Return the simplified canonical path.

Example 1:
Input: path = "/home/"
Output: "/home"
Explanation: Note that there is no trailing slash after the last directory name.

Example 2:
Input: path = "/../"
Output: "/"
Explanation: Going one level up from the root directory is a no-op, as the root level is the highest level you can go.
*/

import java.util.*;

public class SimplifyPath {
    public static void main(String[] args) throws InterruptedException {
        List<String> input =     Arrays.asList("/a/../../../../b/../c//.//", "/home/", "/../", "/home//foo/", "/a/./b/../../c/", "/a//b////c/d//././/..");
        List<String> expOutput = Arrays.asList("/c"                  , "/home",  "/",    "/home/foo",   "/c",              "/a/b/c");
        Solution solution = new Solution();
        for (int i = 0; i < input.size(); i++) {
            String result = solution.simplifyPath(input.get(i));
            System.out.println(result.equals(expOutput.get(i)) + "\t" + expOutput.get(i) + "=" + result);
        }
    }
}

class Solution {
    public String simplifyPath(String path) {
        // 1. remove ///// sequence
        path = path.replaceAll("/+", "/");

        // 2. remove last /
        path = (path.endsWith("/")) ? path.substring(0, path.length()-1) : path;

        String[] dirArr = path.split("/");
        Deque<String> stack = new ArrayDeque<>();
        for (String dir : dirArr) {
            if (".".equals(dir)) continue;
            if ("..".equals(dir)) {
                if (!"".equals(stack.peekLast())) stack.removeLast();
            } else  {
                stack.add(dir);
            }
        }

        path = String.join("/", stack);
        path = path.equals("") ? "/" : path;
        return path;
    }
}