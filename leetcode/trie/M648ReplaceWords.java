package trie;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class M648ReplaceWords {

    public String replaceWords(List<String> dictionary, String sentence) {
        TrieNode root = buildTrie(dictionary);
        return replace(root, sentence);
    }

    private String replace(TrieNode root, String sentence) {
        StringBuilder ans = new StringBuilder();
        String[] words = sentence.split("\\s");
        for (String word : words) {
            TrieNode temp = root;
            for (char c : word.toCharArray()) {
                Map<Character, TrieNode> tempMap = temp.map;
                if (!tempMap.containsKey(c) || temp.word != null) {
                    break;
                }
                temp = tempMap.get(c);
            }
            ans.append(temp.word != null ? temp.word : word).append(" ");
        }
        return ans.toString().trim();
    }

    private TrieNode buildTrie(List<String> dictionary) {
        TrieNode root = new TrieNode();
        for (String word : dictionary) {
            TrieNode temp = root;
            for (char c : word.toCharArray()) {
                Map<Character, TrieNode> tempMap = temp.map;
                if (!tempMap.containsKey(c)) {
                    tempMap.put(c, new TrieNode());
                }
                temp = tempMap.get(c);
            }
            temp.word = word;
        }
        return root;
    }

    private static class TrieNode {
        String word;
        final Map<Character, TrieNode> map;

        public TrieNode() {
            word = null;
            map = new HashMap<>();
        }
    }
}
