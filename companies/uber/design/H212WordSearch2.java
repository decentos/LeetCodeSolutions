package uber.design;

import java.util.ArrayList;
import java.util.List;

public class H212WordSearch2 {

    public List<String> findWords(char[][] board, String[] words) {
        int m = board.length, n = board[0].length;
        boolean[][] visited  = new boolean[m][n];
        List<String> exists = new ArrayList<>();
        TrieNode root = buildTrie(words);

        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                searchWords(exists, root, board, visited, row, col);
            }
        }
        return exists;
    }

    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();

        for (String word : words) {
            TrieNode temp = root;
            for (char letter : word.toCharArray()) {
                TrieNode[] children = temp.children;
                if (children[letter - 'a'] == null) {
                    children[letter - 'a'] = new TrieNode();
                }
                temp = children[letter - 'a'];
            }
            temp.word = word;
        }
        return root;
    }

    private void searchWords(List<String> exists, TrieNode node, char[][] board, boolean[][] visited, int row, int col) {
        if (row < 0 || row  >= board.length || col < 0 || col >= board[0].length || visited[row][col] || node.children[board[row][col] - 'a'] == null) {
            return;
        }
        visited[row][col] = true;
        node = node.children[board[row][col] - 'a'];

        if (node.word != null) {
            exists.add(node.word);
            node.word = null;
        }

        searchWords(exists, node, board, visited, row + 1, col);
        searchWords(exists, node, board, visited, row - 1, col);
        searchWords(exists, node, board, visited, row, col + 1);
        searchWords(exists, node, board, visited, row, col - 1);

        visited[row][col] = false;
    }

    private static class TrieNode {
        String word;
        TrieNode[] children;

        public TrieNode() {
            word = null;
            children = new TrieNode[26];
        }
    }
}
