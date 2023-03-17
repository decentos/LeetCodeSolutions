package trie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class M211DesignAddSearchStructure {
    private boolean isFullWord;
    private final Map<Character, M211DesignAddSearchStructure> map;

    public M211DesignAddSearchStructure() {
        isFullWord = false;
        map = new HashMap<>();
    }

    public void addWord(String word) {
        M211DesignAddSearchStructure curr = this;
        for (char c : word.toCharArray()) {
            Map<Character, M211DesignAddSearchStructure> currMap = curr.map;
            if (!currMap.containsKey(c)) {
                currMap.put(c, new M211DesignAddSearchStructure());
            }
            curr = currMap.get(c);
        }
        curr.isFullWord = true;
    }

    public boolean search(String word) {
        List<M211DesignAddSearchStructure> candidates = new ArrayList<>();
        candidates.add(this);
        for (char c : word.toCharArray()) {
            List<M211DesignAddSearchStructure> next = new ArrayList<>();
            for (M211DesignAddSearchStructure dict : candidates) {
                Map<Character, M211DesignAddSearchStructure> currMap = dict.map;
                if (c == '.') {
                    next.addAll(currMap.values());
                } else if (currMap.containsKey(c)) {
                    next.add(currMap.get(c));
                }
            }
            if (next.isEmpty()) return false;
            candidates = next;
        }
        return candidates.stream().anyMatch(it -> it.isFullWord);
    }
}
