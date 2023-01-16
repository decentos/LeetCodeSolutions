package me.decentos.leetcode.easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class RomanToInt {

    public static int romanToInt(String s) {
        int decrement = 0;
        if (s.contains("IV") || s.contains("IX")) decrement += 2;
        if (s.contains("XL") || s.contains("XC")) decrement += 20;
        if (s.contains("CD") || s.contains("CM")) decrement += 200;

        AtomicInteger result = new AtomicInteger();
        char[] arr = s.toCharArray();
        List<String> list = new ArrayList<>();
        for (char c : arr) {
            list.add(String.valueOf(c));
        }
        list.forEach(it -> result.addAndGet(map.get(it)));
        return result.get() - decrement;
    }

    private static final Map<String, Integer> map = Map.of(
            "I", 1,
            "V", 5,
            "X", 10,
            "L", 50,
            "C", 100,
            "D", 500,
            "M", 1000
    );
}
