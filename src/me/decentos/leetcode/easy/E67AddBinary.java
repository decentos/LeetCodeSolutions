package me.decentos.leetcode.easy;

public class E67AddBinary {

    public static String addBinary(String a, String b) {
        char[] aChars = a.toCharArray();
        char[] bChars = b.toCharArray();
        if (aChars.length < bChars.length) {
            char[] temp = aChars;
            aChars = bChars;
            bChars = temp;
        }
        int carry = 0, aPtr = aChars.length - 1, bPtr = bChars.length - 1;
        while (bPtr >= 0) {
            char aElement = aChars[aPtr];
            char bElement = bChars[bPtr];
            if (aElement == '1' && bElement == '1' && carry == 1) {
                aChars[aPtr] = '1';
            } else if (aElement == '1' && bElement == '1') {
                aChars[aPtr] = '0';
                carry = 1;
            } else if ((aElement == '1' || bElement == '1') && carry == 1) {
                aChars[aPtr] = '0';
            } else if (aElement == '1' || bElement == '1') {
                aChars[aPtr] = '1';
            } else if (aElement == '0' && bElement == '0' && carry == 1) {
                aChars[aPtr] = '1';
                carry = 0;
            }
            aPtr--;
            bPtr--;
        }
        while (aPtr >= 0 && carry == 1) {
            char aElement = aChars[aPtr];
            if (aElement == '0') {
                aChars[aPtr] = '1';
                carry = 0;
            } else {
                aChars[aPtr] = '0';
            }
            aPtr--;
        }
        if (carry == 1) {
            char[] extra = new char[aChars.length + 1];
            System.arraycopy(aChars, 0, extra, 1, aChars.length);
            extra[0] = '1';
            return new String(extra);
        }
        return new String(aChars);
    }
}
