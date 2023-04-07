package string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class M249GroupShiftedStrings {

    public List<List<String>> groupStrings(String[] strings) {
        Map<String, List<String>> map = new HashMap<>();
        for (String word : strings) {
            char[] chars = word.toCharArray();
            int diff = chars[0] - 'a';
            for (int i = 0; i < chars.length; i++) {
                chars[i] -= diff;
                if (chars[i] < 97) chars[i] += 26;
            }
            String sorted = String.valueOf(chars);
            map.computeIfAbsent(sorted, val -> new ArrayList<>()).add(word);
        }
        return new ArrayList<>(map.values());
    }
}
