package tree.trie;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class M1268SearchSuggestionsSystem {

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        TrieNode root = buildTrie(products);
        return search(root, searchWord);
    }

    private TrieNode buildTrie(String[] products) {
        TrieNode root = new TrieNode();
        for (String product : products) {
            TrieNode curr = root;
            for (char c : product.toCharArray()) {
                TrieNode[] children = curr.children;
                if (children[c - 'a'] == null) {
                    children[c - 'a'] = new TrieNode();
                }
                curr = children[c - 'a'];
                curr.words.add(product);

                if (curr.words.size() > 3) {
                    curr.words.pollLast();
                }
            }
        }
        return root;
    }

    private List<List<String>> search(TrieNode root, String searchWord) {
        List<List<String>> suggestions = new ArrayList<>();
        for (int i = 0; i < searchWord.length(); i++) {
            suggestions.add(new ArrayList<>());
        }
        TrieNode node = root;

        for (int i = 0; i < searchWord.length(); i++) {
            TrieNode[] children = node.children;
            int curr = searchWord.charAt(i) - 'a';
            if (children[curr] == null) {
                break;
            }
            node = children[curr];
            suggestions.get(i).addAll(node.words);
        }
        return suggestions;
    }

    private static class TrieNode {
        TreeSet<String> words;
        TrieNode[] children;

        public TrieNode() {
            words = new TreeSet<>();
            children = new TrieNode[26];
        }
    }
}
