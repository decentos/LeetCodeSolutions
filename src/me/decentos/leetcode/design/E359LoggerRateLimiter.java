package me.decentos.leetcode.design;

import java.util.HashMap;
import java.util.Map;

public class E359LoggerRateLimiter {
    private final Map<String, Integer> map;

    public E359LoggerRateLimiter() {
        map = new HashMap<>();
    }

    public boolean shouldPrintMessage(int timestamp, String message) {
        Integer currTimestamp = map.get(message);
        if (currTimestamp == null || timestamp - currTimestamp >= 10) {
            map.put(message, timestamp);
            return true;
        }
        return false;
    }
}
