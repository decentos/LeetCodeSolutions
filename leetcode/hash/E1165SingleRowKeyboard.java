package hash;

import java.util.HashMap;
import java.util.Map;

public class E1165SingleRowKeyboard {

    public int calculateTime(String keyboard, String word) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < 26; i++) {
            map.put(keyboard.charAt(i), i);
        }

        int count = 0, prev = 0;
        for (char c : word.toCharArray()) {
            int index = map.get(c);
            int diff = Math.abs(index - prev);
            count += diff;
            prev = index;
        }
        return count;
    }
}
