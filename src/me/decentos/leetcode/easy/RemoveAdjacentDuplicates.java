package me.decentos.leetcode.easy;

import java.util.Stack;

public class RemoveAdjacentDuplicates {

    public String removeDuplicates(String s) {
        if (s.length() <= 1) return s;
        
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            if (!stack.empty() && stack.peek() == current) {
                stack.pop();
            } else {
                stack.push(current);
            }
        }

        for (char c : stack) sb.append(c);
        return sb.toString();
    }

    public static String removeDuplicates2(String s) {
        if (s.length() <= 1) return s;

        StringBuilder sb = new StringBuilder(s);

        int slow = 0, fast = 1;
        while (fast < sb.length()) {
            if (sb.charAt(slow) == sb.charAt(fast)) {
                sb.deleteCharAt(slow);
                sb.deleteCharAt(slow);
                if (slow != 0) slow--;
                if (fast != 1) fast--;
            } else {
                slow++;
                fast++;
            }
        }
        return sb.toString();
    }
}
