package stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class M227BasicCalculator2 {

    public int calculate(String s) {
        int n = s.length();
        Deque<Integer> stack = new ArrayDeque<>();
        char currOperation = '+';
        int currNumber = 0, result = 0;

        for (int i = 0; i < n; i++) {
            char curr = s.charAt(i);

            if (Character.isWhitespace(curr)) {
                continue;
            }

            if (Character.isDigit(curr)) {
                currNumber = currNumber * 10 + curr - '0';

                if (i == n - 1 || !Character.isDigit(s.charAt(i + 1))) {
                    if (currOperation == '*') {
                        stack.push(stack.pop() * currNumber);
                    } else if (currOperation == '/') {
                        stack.push(stack.pop() / currNumber);
                    } else if (currOperation == '-') {
                        stack.push(-currNumber);
                    } else {
                        stack.push(currNumber);
                    }
                    currNumber = 0;
                }
            } else {
                currOperation = curr;
            }
        }

        while (!stack.isEmpty()) {
            result += stack.pop();
        }
        return result;
    }

// ===============================================================================

    public int calculate2(String s) {
        int n = s.length();
        char currOperation = '+';
        int currNumber = 0, lastNumber = 0, result = 0;

        for (int i = 0; i < n; i++) {
            char curr = s.charAt(i);

            if (Character.isWhitespace(curr)) {
                continue;
            }

            if (Character.isDigit(curr)) {
                currNumber = currNumber * 10 + curr - '0';

                if (i == n - 1 || !Character.isDigit(s.charAt(i + 1))) {
                    if (currOperation == '*') {
                        lastNumber *= currNumber;
                    } else if (currOperation == '/') {
                        lastNumber /= currNumber;
                    } else {
                        result += lastNumber;
                        lastNumber = currOperation == '-' ? -currNumber : currNumber;
                    }
                    currNumber = 0;
                }
            } else {
                currOperation = curr;
            }
        }
        return result + lastNumber;
    }
}
