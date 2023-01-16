package me.decentos.leetcode.easy;

import java.util.Arrays;

public class E242ValidAnagram {

    public boolean isAnagram(String s, String t) {
        if (s == null || t == null)
            return false;

        if (s.length() != t.length())
            return false;

        String firstSort = sortString(s);
        String secondSort = sortString(t);
        return firstSort.equals(secondSort);
    }

    private String sortString(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}
