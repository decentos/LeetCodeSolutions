package stack;

import java.util.Stack;

public class E1047RemoveAdjacentDuplicates {

    public String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && c == stack.peek()) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }

        StringBuilder ans = new StringBuilder();
        for (char c : stack) ans.append(c);
        return ans.toString();
    }

    public static String removeDuplicates2(String s) {
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
