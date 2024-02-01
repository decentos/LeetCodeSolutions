package design;

import java.util.Stack;

public class E232QueueViaStacks {
    private final Stack<Integer> stack;
    private final Stack<Integer> reverse;

    public E232QueueViaStacks() {
        stack = new Stack<>();
        reverse = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
    }

    public int pop() {
        if (reverse.isEmpty()) {
            while (!stack.isEmpty()) {
                reverse.push(stack.pop());
            }
        }
        return reverse.pop();
    }

    public int peek() {
        if (reverse.isEmpty()) {
            while (!stack.isEmpty()) {
                reverse.push(stack.pop());
            }
        }
        return reverse.peek();
    }

    public boolean empty() {
        return stack.isEmpty() && reverse.isEmpty();
    }
}
