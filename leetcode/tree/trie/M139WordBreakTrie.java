package tree.trie;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;


/**
 * DP solution {@link dp.M139WordBreakDP}
 */
public class M139WordBreakTrie {

    public boolean wordBreak(String s, List<String> wordDict) {
        Queue<String> substrings = new LinkedList<>();
        substrings.offer(s + "#");
        TrieNode root = buildTrie(wordDict);

        while (!substrings.isEmpty()) {
            String sub = substrings.poll();
            if (sub.equals("#")) return true;

            TrieNode temp = root;
            for (int i = 0; i < sub.length(); i++) {
                char curr = sub.charAt(i);
                Map<Character, TrieNode> children = temp.children;

                if (!children.containsKey(curr)) break;
                temp = children.get(curr);

                if (temp.isWord && i < sub.length() - 1) {
                    String next = sub.substring(i + 1);
                    if (!substrings.contains(next)) {
                        substrings.offer(next);
                    }
                }
            }
        }
        return false;
    }

    private TrieNode buildTrie(List<String> wordDict) {
        TrieNode root = new TrieNode();

        for (String word : wordDict) {
            TrieNode temp = root;

            for (char curr : word.toCharArray()) {
                Map<Character, TrieNode> children = temp.children;
                if (!children.containsKey(curr)) {
                    children.put(curr, new TrieNode());
                }
                temp = children.get(curr);
            }
            temp.isWord = true;
        }
        return root;
    }

    private static class TrieNode {
        boolean isWord;
        Map<Character, TrieNode> children;

        public TrieNode() {
            isWord = false;
            children = new HashMap<>();
        }
    }
}
