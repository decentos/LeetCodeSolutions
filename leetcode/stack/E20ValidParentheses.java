package stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class E20ValidParentheses {

    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for (char bracket : s.toCharArray()) {
            if (bracket == '(' || bracket == '[' || bracket == '{') {
                stack.push(bracket);
                continue;
            } else if (stack.isEmpty()) {
                return false;
            }

            char openBracket = stack.pop();
            if (openBracket == '(' && bracket != ')' || openBracket == '[' && bracket != ']' || openBracket == '{' && bracket != '}') {
                return false;
            }
        }
        return stack.isEmpty();
    }
}
