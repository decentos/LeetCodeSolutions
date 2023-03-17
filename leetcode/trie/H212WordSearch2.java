package trie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class H212WordSearch2 {

    public List<String> findWords(char[][] board, String[] words) {
        List<String> ans = new ArrayList<>();
        TrieNode root = buildTrie(words);

        int m = board.length, n = board[0].length;
        boolean[][] used = new boolean[m][n];
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                dfs(ans, board, root, used, row, col);
            }
        }

        return ans;
    }

    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
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

    private void dfs(List<String> ans, char[][] board, TrieNode node, boolean[][] used, int row, int col) {
        if (row < 0 || col < 0 || row == board.length || col == board[0].length || used[row][col]) return;
        if (!node.map.containsKey(board[row][col])) return;

        used[row][col] = true;
        node = node.map.get(board[row][col]);

        if (node.word != null) {
            ans.add(node.word);
            node.word = null;
        }

        dfs(ans, board, node, used, row + 1, col);
        dfs(ans, board, node, used, row - 1, col);
        dfs(ans, board, node, used, row, col + 1);
        dfs(ans, board, node, used, row, col - 1);

        used[row][col] = false;
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
