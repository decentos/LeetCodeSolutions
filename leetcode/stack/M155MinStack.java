package stack;

import java.util.Objects;
import java.util.Stack;

public class M155MinStack {

    private final Stack<Integer> stack;
    private final Stack<Integer> minStack;;

    public M155MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);
        if (minStack.isEmpty() || minStack.peek() >= val) {
            minStack.push(val);
        }
    }

    public void pop() {
        if (Objects.equals(minStack.peek(), stack.peek())) {
            minStack.pop();
        }
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
