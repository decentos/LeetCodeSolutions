package me.decentos.leetcode.easy;

import java.util.Set;

public class ReverseVowels {

    public static String reverseVowels(String s) {
        if (s.length() == 1) return s;

        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');
        char[] letters = s.toCharArray();
        int l = 0, r = letters.length - 1;

        while (l < r) {
            char leftChar = letters[l];
            char rightChar = letters[r];
            boolean leftIsVowel = vowels.contains(leftChar);
            boolean rightIsVowel = vowels.contains(rightChar);
            if (leftIsVowel && rightIsVowel) {
                letters[l] = rightChar;
                letters[r] = leftChar;
                l++;
                r--;
            } else if (leftIsVowel) {
                r--;
            } else if (rightIsVowel) {
                l++;
            } else {
                l++;
                r--;
            }
        }
        return String.valueOf(letters);
    }
}
