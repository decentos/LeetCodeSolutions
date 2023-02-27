package medium;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class M394DecodeString {
    private int index = 0;

    public String decodeString(String s) {
        StringBuilder decode = new StringBuilder();
        int times = 0;

        while (index < s.length()) {
            while (index < s.length() && Character.isLetter(s.charAt(index))) {
                decode.append(s.charAt(index));
                index++;
            }

            if (index >= s.length() || s.charAt(index) == ']') {
                index++;
                break;
            } else if (s.charAt(index) == '[') {
                index++;
                String nested = decodeString(s);
                decode.append(nested.repeat(times));
                times = 0;
            } else {
                StringBuilder sTimes = new StringBuilder();
                while (index < s.length() && Character.isDigit(s.charAt(index))) {
                    sTimes.append(s.charAt(index));
                    index++;
                }
                times = Integer.parseInt(sTimes.toString());
            }
        }
        return decode.toString();
    }

// ===============================================================================

    public String decodeString2(String s) {
        Map<Integer, Integer> brackets = new HashMap<>();
        Stack<Integer> openBrackets = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            if (curr == '[') {
                openBrackets.push(i);
            } else if (curr == ']') {
                int openBracket = openBrackets.pop();
                brackets.put(openBracket, i);
            }
        }
        return decode(s, brackets, 0, s.length() - 1);
    }

    private String decode(String s, Map<Integer, Integer> brackets, int l, int r) {
        StringBuilder sb = new StringBuilder();
        int times = 0;
        for (int i = l; i <= r; i++) {
            char curr = s.charAt(i);
            if (Character.isLetter(curr)) {
                sb.append(curr);
            } else if (Character.isDigit(curr)) {
                times = times * 10 + curr - '0';
            } else if (curr == '[') {
                int closeBracket = brackets.get(i);
                String nested = decode(s, brackets, i + 1, closeBracket - 1);
                sb.append(nested.repeat(times));
                times = 0;
                i = closeBracket;
            }
        }
        return sb.toString();
    }
}
