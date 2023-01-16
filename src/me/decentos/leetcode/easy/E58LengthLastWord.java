package me.decentos.leetcode.easy;

public class E58LengthLastWord {

    public static int lengthOfLastWord(String s) {
        String trim = s.trim();
        int afterLastSpaceIndex = trim.lastIndexOf(' ') + 1;
        return trim.length() - afterLastSpaceIndex;
    }

    public int lengthOfLastWord2(String s) {
        int index = s.length() - 1, length = 0;
        while (index >= 0) {
            if (s.charAt(index) != ' ') length++;
            else if (length > 0) return length;
            index--;
        }
        return length;
    }
}
