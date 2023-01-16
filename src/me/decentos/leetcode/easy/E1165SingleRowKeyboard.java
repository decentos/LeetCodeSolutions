package me.decentos.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class E1165SingleRowKeyboard {

    public int calculateTime(String keyboard, String word) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : keyboard.toCharArray()) map.put(c, keyboard.indexOf(c));
        int currentPosition = 0, count = 0;

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int position = map.get(c);
            int moveCount = Math.abs(position - currentPosition);
            count += moveCount;
            currentPosition = position;
        }
        return count;
    }
}
