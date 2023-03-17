package trie;

import java.util.HashMap;
import java.util.Map;

public class M677MapSumPairs {
    private int val;
    private final Map<Character, M677MapSumPairs> map;

    public M677MapSumPairs() {
        val = 0;
        map = new HashMap<>();
    }

    public void insert(String key, int val) {
        M677MapSumPairs curr = this;
        for (char c : key.toCharArray()) {
            Map<Character, M677MapSumPairs> currMap = curr.map;
            if (!currMap.containsKey(c)) {
                currMap.put(c, new M677MapSumPairs());
            }
            curr = currMap.get(c);
        }
        curr.val = val;
    }

    public int sum(String prefix) {
        M677MapSumPairs curr = this;
        for (char c : prefix.toCharArray()) {
            Map<Character, M677MapSumPairs> currMap = curr.map;
            if (!currMap.containsKey(c)) {
                currMap.put(c, new M677MapSumPairs());
            }
            curr = currMap.get(c);
        }
        return dfs(curr);
    }

    private int dfs(M677MapSumPairs node) {
        int sum = 0;
        for (char c : node.map.keySet()) {
            sum += dfs(node.map.get(c));
        }
        return sum + node.val;
    }
}
