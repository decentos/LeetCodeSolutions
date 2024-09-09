package stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class M2390RemovingStars {

    public String removeStars(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for (char c : s.toCharArray()) {
            if (c == '*') {
                stack.pop();
            } else {
                stack.push(c);
            }
        }

        char[] removed = new char[stack.size()];
        for (int i = removed.length - 1; i >= 0; i--) {
            removed[i] = stack.pop();
        }
        return String.valueOf(removed);
    }
}
