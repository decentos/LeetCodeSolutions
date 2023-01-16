package me.decentos.leetcode.easy;

public class E844BackspaceString {

    public static boolean backspaceCompare(String s, String t) {
        int sPointer = 0, tPointer = 0;
        StringBuilder sSb = new StringBuilder(s);
        StringBuilder tSb = new StringBuilder(t);

        while (sPointer < sSb.length() && !sSb.isEmpty()) {
            if (sPointer + 1 < sSb.length() && sSb.charAt(sPointer + 1) == '#') {
                sSb.delete(sPointer, sPointer + 2);
                if (sPointer > 0) {
                    sPointer--;
                }
            } else {
                sPointer++;
            }
        }

        while (tPointer < tSb.length() && !tSb.isEmpty()) {
            if (tPointer + 1 < tSb.length() && tSb.charAt(tPointer + 1) == '#') {
                tSb.delete(tPointer, tPointer + 2);
                if (tPointer > 0) {
                    tPointer--;
                }
            } else {
                tPointer++;
            }
        }
        return sSb.toString().replace("#", "").equals(tSb.toString().replace("#", ""));
    }
}
