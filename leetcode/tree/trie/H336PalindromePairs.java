package tree.trie;

import java.util.ArrayList;
import java.util.List;

public class H336PalindromePairs {

    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> ans = new ArrayList<>();
        TrieNode root = buildTrie(words);
        searchPalindrome(ans, root, words);
        return ans;
    }

    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (int i = 0; i < words.length; i++) {
            TrieNode temp = root;
            char[] word = reverse(words[i].toCharArray());
            for (int j = 0; j < word.length; j++) {
                if (isPalindrome(word, j)) {
                    temp.palindromeIndexes.add(i);
                }
                int index = word[j] - 'a';
                if (temp.children[index] == null) {
                    temp.children[index] = new TrieNode();
                }
                temp = temp.children[index];
            }
            temp.index = i;
        }
        return root;
    }

    private void searchPalindrome(List<List<Integer>> ans, TrieNode root, String[] words) {
        for (int i = 0; i < words.length; i++) {
            TrieNode temp = root;
            char[] word = words[i].toCharArray();
            for (int j = 0; j < word.length; j++) {
                if (temp.index != -1 && isPalindrome(word, j)) {
                    ans.add(List.of(i, temp.index));
                }

                temp = temp.children[word[j] - 'a'];
                if (temp == null) break;
            }
            if (temp == null) continue;

            if (temp.index != -1 && i != temp.index) {
                ans.add(List.of(i, temp.index));
            }

            for (int index : temp.palindromeIndexes) {
                ans.add(List.of(i, index));
            }
        }
    }

    private char[] reverse(char[] word) {
        int left = 0, right = word.length - 1;
        while (left < right) {
            char temp = word[left];
            word[left] = word[right];
            word[right] = temp;
            left++;
            right--;
        }
        return word;
    }

    private boolean isPalindrome(char[] word, int left) {
        int right = word.length - 1;
        while (left < right) {
            if (word[left] != word[right]) return false;
            left++;
            right--;
        }
        return true;
    }

    private static class TrieNode {
        int index;
        List<Integer> palindromeIndexes;
        TrieNode[] children;

        public TrieNode() {
            index = -1;
            palindromeIndexes = new ArrayList<>();
            children = new TrieNode[26];
        }
    }
}