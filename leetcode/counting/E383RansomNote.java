package counting;

import java.util.HashMap;
import java.util.Map;

public class E383RansomNote {

    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : magazine.toCharArray()) map.merge(c, 1, Integer::sum);

        for (char c : ransomNote.toCharArray()) {
            Integer count = map.get(c);
            if (count == null || count == 0) return false;
            map.replace(c, count - 1);
        }
        return true;
    }
}
