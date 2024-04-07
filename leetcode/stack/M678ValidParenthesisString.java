package stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class M678ValidParenthesisString {

    public boolean checkValidString(String s) {
        Deque<Integer> opens = new ArrayDeque<>();
        Deque<Integer> stars = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            if (curr == '*') {
                stars.push(i);
            } else if (curr == '(') {
                opens.push(i);
            } else {
                if (!opens.isEmpty()) {
                    opens.pop();
                } else if (!stars.isEmpty()) {
                    stars.pop();
                } else {
                    return false;
                }
            }
        }

        while (!opens.isEmpty()) {
            if (stars.isEmpty()) {
                return false;
            } else if (stars.peek() > opens.peek()) {
                opens.pop();
                stars.pop();
            } else {
                return false;
            }
        }
        return true;
    }
}
