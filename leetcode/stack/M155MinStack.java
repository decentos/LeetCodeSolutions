package stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class M155MinStack {
    private final Deque<Value> stack;

    public M155MinStack() {
        stack = new ArrayDeque<>();
    }

    public void push(int val) {
        if (stack.isEmpty()) {
            stack.push(new Value(val, val));
        } else {
            int min = Math.min(val, stack.peek().currMin);
            stack.push(new Value(val, min));
        }
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek().value;
    }

    public int getMin() {
        return stack.peek().currMin;
    }

    private record Value(int value, int currMin) {
    }
}
