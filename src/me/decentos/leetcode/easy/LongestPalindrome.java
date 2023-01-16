package me.decentos.leetcode.easy;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class LongestPalindrome {

    public int longestPalindrome(String s) {
        if (s.length() == 1) return 1;

        AtomicInteger result = new AtomicInteger();
        AtomicBoolean firstOdd = new AtomicBoolean(false);
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.merge(c, 1, Integer::sum);
        }

        map.forEach((k, v) -> {
            result.addAndGet(v / 2 * 2);
            if (Boolean.FALSE.equals(firstOdd.get()) && v % 2 != 0) { // result.get() % 2 == 0 instead boolean
                result.addAndGet(1);
                firstOdd.set(true);
            }
        });
        return result.get();
    }
}
