package me.decentos.leetcode.easy;

import java.util.Set;

public class E1704StringAlike {

    public boolean halvesAreAlike(String s) {
        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');
        int countA = 0, countB = 0, midIndex = s.length() / 2;
        String a = s.substring(0, midIndex);
        String b = s.substring(midIndex);

        for (int i = 0; i < midIndex; i++) {
            char charA = a.charAt(i);
            char charB = b.charAt(i);
            if (vowels.contains(charA)) countA++;
            if (vowels.contains(charB)) countB++;
        }
        return countA == countB;
    }

    public boolean halvesAreAlike2(String s) {
        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');
        int vowelsCount = 0, midIndex = s.length() / 2;

        for (int i = 0; i < midIndex; i++) {
            char charA = s.charAt(i);
            char charB = s.charAt(midIndex + i);
            if (vowels.contains(charA)) vowelsCount++;
            if (vowels.contains(charB)) vowelsCount--;
        }
        return vowelsCount == 0;
    }
}
