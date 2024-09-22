package tree.trie;

import java.util.HashMap;
import java.util.Map;

public class M208ImplementTrie {
    private boolean isFullWord;
    private final Map<Character, M208ImplementTrie> map;

    public M208ImplementTrie() {
        map = new HashMap<>();
        isFullWord = false;
    }

    public void insert(String word) {
        M208ImplementTrie curr = this;
        for (char c : word.toCharArray()) {
            Map<Character, M208ImplementTrie> currMap = curr.map;
            if (!currMap.containsKey(c)) {
                currMap.put(c, new M208ImplementTrie());
            }
            curr = currMap.get(c);
        }
        curr.isFullWord = true;
    }

    public boolean search(String word) {
        M208ImplementTrie curr = this;
        for (char c : word.toCharArray()) {
            Map<Character, M208ImplementTrie> currMap = curr.map;
            if (currMap.containsKey(c)) {
                curr = currMap.get(c);
            } else {
                return false;
            }
        }
        return curr.isFullWord;
    }

    public boolean startsWith(String prefix) {
        Map<Character, M208ImplementTrie> curr = map;
        for (char c : prefix.toCharArray()) {
            if (curr.containsKey(c)) {
                curr = curr.get(c).map;
            } else {
                return false;
            }
        }
        return true;
    }
}
