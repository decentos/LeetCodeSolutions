package uber.design;

public class H224BasicCalculator {

    public int calculate(String s) {
        return calculate(s, new int[1]);
    }

    private int calculate(String s, int[] index) {
        int result = 0;
        int operation = 1;
        int number = 0;

        while (index[0] < s.length()) {
            char curr = s.charAt(index[0]++);

            if (Character.isWhitespace(curr)) {
                continue;
            }

            if (Character.isDigit(curr)) {
                number = number * 10 + curr - '0';
            } else if (curr == '(') {
                number = calculate(s, index);
            } else if (curr == ')') {
                break;
            } else {
                result += number * operation;
                number = 0;
                operation = curr == '+' ? 1 : -1;
            }
        }
        return result + (number * operation);
    }
}
