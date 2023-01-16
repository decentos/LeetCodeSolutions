package me.decentos.leetcode.easy;

public class E14CommonPrefix {

    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (i == strs[j].length() || c != strs[j].charAt(i)) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }

    public String longestCommonPrefix2(String[] strs) {
        StringBuilder sb = new StringBuilder();
        String first = strs[0];
        for (int i = 0; i < first.length(); i++) {
            char chatAtFirst = first.charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (i >= strs[j].length() || strs[j].charAt(i) != chatAtFirst) {
                    return sb.toString();
                }
            }
            sb.append(chatAtFirst);
        }
        return sb.toString();
    }
}
