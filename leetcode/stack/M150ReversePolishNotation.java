package stack;

import java.util.Set;
import java.util.Stack;

public class M150ReversePolishNotation {

    public int evalRPN(String[] tokens) {
        Set<String> operands = Set.of("+", "-", "*", "/");
        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {
            if (operands.contains(token)) {
                int num1 = stack.pop();
                int num2 = stack.pop();
                switch (token) {
                    case "+" -> stack.push(num2 + num1);
                    case "-" -> stack.push(num2 - num1);
                    case "*" -> stack.push(num2 * num1);
                    case "/" -> stack.push(num2 / num1);
                };
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }
}
