package me.decentos.leetcode.medium;

public class M394DecodeString {
    static int index = 0;

    public static String decodeString(String s) {
        StringBuilder result = new StringBuilder();
        int times = 0;

        while (index < s.length()) {
            char current = s.charAt(index);
            index++;

            if (current == ']') {
                break;
            }
            if (Character.isLetter(current)) {
                result.append(current);
                continue;
            }
            if (current == '[') {
                String temp = decodeString(s);
                result.append(temp.repeat(times));
                times = 0;
            } else {
                StringBuilder sTimes = new StringBuilder();
                index = index - 1;
                while (Character.isDigit(s.charAt(index))) {
                    sTimes.append(s.charAt(index));
                    index++;
                }
                times = Integer.parseInt(sTimes.toString());
//                times = times * 10 + current - '0'; //handle count case which has more than one digit
            }
        }
        return result.toString();
    }
}
