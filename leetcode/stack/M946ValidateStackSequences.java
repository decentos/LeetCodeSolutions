package stack;

import java.util.Stack;

public class M946ValidateStackSequences {

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int n = pushed.length, index = 0;
        Stack<Integer> stack = new Stack<>();

        for (int num : pushed) {
            stack.push(num);
            while (!stack.isEmpty() && index < n && stack.peek() == popped[index]) {
                stack.pop();
                index++;
            }
        }
        return index == n;
    }
}
