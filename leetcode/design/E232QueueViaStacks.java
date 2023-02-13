package design;

import java.util.Stack;

public class E232QueueViaStacks {
    private final Stack<Integer> stack;
    private final Stack<Integer> queue;

    public E232QueueViaStacks() {
        stack = new Stack<>();
        queue = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
    }

    public int pop() {
        if (!queue.isEmpty()) {
            return queue.pop();
        }
        while (!stack.isEmpty()) {
            queue.push(stack.pop());
        }
        return queue.pop();
    }

    public int peek() {
        if (!queue.isEmpty()) {
            return queue.peek();
        }
        while (!stack.isEmpty()) {
            queue.push(stack.pop());
        }
        return queue.peek();
    }

    public boolean empty() {
        return stack.isEmpty() && queue.isEmpty();
    }
}
