package dev.vlads.tasks.Brackets;

import java.util.Stack;

public class Brackets {
    public static void main(String[] args) {

    }
}

class Solution {
    public int solution(String S) {
        if (S.length() == 0) return 1;
        Stack<String> stack = new Stack<>();

        for (String str : S.split("")) {
            if (str.equals("(") || str.equals("{") || str.equals("[")) {
                stack.add(str);
            } else  {
                if (stack.isEmpty() || !findOpenBrackets(str).equals(stack.pop())) {
                    return 0;
                }
            }
        }

        if (stack.isEmpty()) {
            return 1;
        } else {
            return 0;
        }
    }

    private String findOpenBrackets(String s) {
        switch (s) {
            case ")" : return "(";
            case "]" : return "[";
            case "}" : return "{";
            default: throw new IllegalArgumentException("Argument " + s + " is not supported. Supported arguments are ),],}");
        }
    }
}
