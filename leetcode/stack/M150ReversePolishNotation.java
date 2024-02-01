package stack;

import java.util.Set;
import java.util.Stack;

public class M150ReversePolishNotation {

    public int evalRPN(String[] tokens) {
        Set<String> operators = Set.of("+", "-", "*", "/");
        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {
            if (operators.contains(token)) {
                int second = stack.pop();
                int first = stack.pop();
                switch (token) {
                    case "+" -> stack.push(first + second);
                    case "-" -> stack.push(first - second);
                    case "*" -> stack.push(first * second);
                    case "/" -> stack.push(first / second);
                }
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }
}
