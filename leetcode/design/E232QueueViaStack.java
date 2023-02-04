package design;

import java.util.Stack;

public class E232QueueViaStack {
    private final Stack<Integer> stack;
    private final Stack<Integer> queue;
    private boolean isStack = true;

    public E232QueueViaStack() {
        stack = new Stack<>();
        queue = new Stack<>();
    }

    public void push(int x) {
        if (!isStack) {
            while (!queue.empty()) {
                int cur = queue.pop();
                stack.push(cur);
            }
            isStack = true;
        }
        stack.push(x);
    }

    public int pop() {
        if (isStack) {
            while (!stack.empty()) {
                int x = stack.pop();
                queue.push(x);
            }
            isStack = false;
        }
        return queue.pop();
    }

    public int peek() {
        if (isStack) {
            while (!stack.empty()) {
                int cur = stack.pop();
                queue.push(cur);
            }
            isStack = false;
        }
        return queue.peek();
    }

    public boolean empty() {
        return stack.empty() && queue.empty();
    }
}
