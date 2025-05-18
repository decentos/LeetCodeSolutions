package booking;

import java.util.ArrayDeque;
import java.util.Deque;

public class E20ValidParentheses {

    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for (char curr : s.toCharArray()) {
            if (curr == '(' || curr == '[' || curr == '{') {
                stack.push(curr);
            } else if (stack.isEmpty()) {
                return false;
            } else {
                char prev = stack.pop();
                if (prev == '(' && curr != ')'
                        || prev == '[' && curr != ']'
                        || prev == '{' && curr != '}') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
