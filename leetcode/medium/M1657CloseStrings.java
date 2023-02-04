package medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class M1657CloseStrings {

    public static boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) return false;

        Map<Character, Integer> map1 = new HashMap<>();
        for (char c : word1.toCharArray()) map1.merge(c, 1, Integer::sum);
        Map<Character, Integer> map2 = new HashMap<>();
        for (char c : word2.toCharArray()) map2.merge(c, 1, Integer::sum);
        if (!map1.keySet().equals(map2.keySet())) return false;

        List<Integer> list1 = new ArrayList<>(map1.values());
        List<Integer> list2 = new ArrayList<>(map2.values());
        Collections.sort(list1);
        Collections.sort(list2);
        return list1.equals(list2);
    }
}
