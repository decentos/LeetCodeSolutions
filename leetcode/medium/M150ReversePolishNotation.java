package medium;

import java.util.Stack;

public class M150ReversePolishNotation {

    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (String s : tokens) {
            if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {
                int i1 = stack.pop();
                int i2 = stack.pop();
                int result = switch (s) {
                    case "+" -> i2 + i1;
                    case "-" -> i2 - i1;
                    case "*" -> i2 * i1;
                    default -> i2 / i1;
                };
                stack.push(result);
            } else {
                stack.push(Integer.valueOf(s));
            }
        }
        return stack.pop();
    }
}
