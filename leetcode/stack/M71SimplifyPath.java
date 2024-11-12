package stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class M71SimplifyPath {

    public String simplifyPath(String path) {
        Deque<String> stack = new ArrayDeque<>();
        String[] parts = path.split("/+");

        for (String part : parts) {
            if (part.isEmpty() || part.equals(".") || (stack.isEmpty() && part.equals(".."))) {
                continue;
            } else if (part.equals("..")) {
                stack.pop();
            } else {
                stack.push(part);
            }
        }

        if (stack.isEmpty()) {
            return "/";
        }

        StringBuilder canonical = new StringBuilder();
        while (!stack.isEmpty()) {
            canonical.append("/").append(stack.pollLast());
        }
        return canonical.toString();
    }
}
