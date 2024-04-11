package stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class M402RemoveKDigits {

    public String removeKdigits(String num, int k) {
        Deque<Character> stack = new ArrayDeque<>();

        for (char c : num.toCharArray()) {
            while (!stack.isEmpty() && stack.peek() > c && k > 0) {
                stack.pop();
                k--;
            }
            stack.push(c);
        }

        while (!stack.isEmpty() && k > 0) {
            stack.pop();
            k--;
        }

        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            char curr = stack.pollLast();
            if (result.isEmpty() && curr == '0') {
                continue;
            }
            result.append(curr);
        }
        return result.isEmpty() ? "0" : result.toString();
    }
}
