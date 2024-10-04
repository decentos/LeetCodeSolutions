package tree.trie;

public class M208ImplementTrie {
    private final TrieNode root;

    public M208ImplementTrie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            TrieNode[] children = node.children;
            if (children[c - 'a'] == null) {
                children[c - 'a'] = new TrieNode();
            }
            node = children[c - 'a'];
        }
        node.isWord = true;
    }

    public boolean search(String word) {
        TrieNode node = searchPrefix(word);
        return node != null && node.isWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode node = searchPrefix(prefix);
        return node != null;
    }

    private TrieNode searchPrefix(String prefix) {
        TrieNode node = root;
        for (char c : prefix.toCharArray()) {
            TrieNode[] children = node.children;
            if (children[c - 'a'] == null) {
                return null;
            }
            node = children[c - 'a'];
        }
        return node;
    }

    private static class TrieNode {
        boolean isWord;
        TrieNode[] children;

        public TrieNode() {
            isWord = false;
            children = new TrieNode[26];
        }
    }
}
