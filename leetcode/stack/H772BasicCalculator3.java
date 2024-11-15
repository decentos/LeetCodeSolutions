package stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class H772BasicCalculator3 {

    public int calculate(String s) {
        return calculate(s, new int[1]);
    }

    private int calculate(String s, int[] index) {
        Deque<Integer> stack = new ArrayDeque<>();
        char operator = '+';
        int number = 0;

        while (index[0] < s.length()) {
            char curr = s.charAt(index[0]);

            if (Character.isDigit(curr)) {
                number = number * 10 + curr - '0';

                if (index[0] == s.length() - 1 || !Character.isDigit(s.charAt(index[0] + 1))) {
                    evaluate(stack, operator, number);
                    number = 0;
                }
            } else if (curr == '(') {
                index[0]++;
                int internal = calculate(s, index);
                evaluate(stack, operator, internal);
            } else if (curr ==')') {
                break;
            } else {
                operator = curr;
            }
            index[0]++;
        }

        int result = 0;
        while (!stack.isEmpty()) {
            result += stack.pop();
        }
        return result;
    }

    private void evaluate(Deque<Integer> stack, char operator, int number) {
        if (operator == '+') {
            stack.push(number);
        } else if (operator == '-') {
            stack.push(-number);
        } else if (operator == '*') {
            stack.push(stack.pop() * number);
        } else {
            stack.push(stack.pop() / number);
        }
    }
}
