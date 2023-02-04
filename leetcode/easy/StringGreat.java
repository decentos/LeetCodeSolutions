package easy;

import java.util.Stack;

public class StringGreat {

    public static String makeGood(String s) {
        if (s.length() <= 1) return s;

        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);

            if (!stack.empty()
                    && stack.peek().toString().equalsIgnoreCase(String.valueOf(current))
                    && stack.peek() != current
            ) {
                stack.pop();
            } else {
                stack.push(current);
            }
        }

        for (char current : stack) {
            sb.append(current);
        }
        return sb.toString();
    }
}
