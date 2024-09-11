package stack;

import java.util.ArrayDeque;
import java.util.Deque;

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
        Deque<Integer> counts = new ArrayDeque<>();
        Deque<StringBuilder> strings = new ArrayDeque<>();
        StringBuilder currentString = new StringBuilder();
        int currentCount = 0;

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                currentCount = currentCount * 10 + c - '0';
            } else if (c == '[') {
                counts.push(currentCount);
                currentCount = 0;

                strings.push(currentString);
                currentString = new StringBuilder();
            } else if (c == ']') {
                int count = counts.pop();
                String repeated = currentString.toString().repeat(count);
                currentString = strings.pop().append(repeated);
            } else {
                currentString.append(c);
            }
        }
        return currentString.toString();
    }
}
