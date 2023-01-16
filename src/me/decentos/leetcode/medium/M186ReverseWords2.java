package me.decentos.leetcode.medium;

public class M186ReverseWords2 {

    public void reverseWords(char[] s) {
        reverse(s, 0, s.length - 1);
        int lastSpace = -1;
        for (int i = 0; i <= s.length; i++) {
            if (i == s.length || s[i] == ' ') {
                reverse(s, lastSpace + 1, i - 1);
                lastSpace = i;
            }
        }
    }

    private void reverse(char[] s, int l, int r) {
        while (l < r) {
            char left = s[l];
            s[l] = s[r];
            s[r] = left;
            l++;
            r--;
        }
    }
}
