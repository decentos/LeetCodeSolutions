package tree.trie;

public class M421MaximumXOR {

    public int findMaximumXOR(int[] nums) {
        TrieNode root = buildTrie(nums);
        return searchMax(nums, root);
    }

    private int searchMax(int[] nums, TrieNode root) {
        int max = 0;
        for (int num : nums) {
            TrieNode temp = root;
            int currSum = 0;
            for (int i = 31; i >= 0; i--) {
                int targetBit = 1 - ((num >> i) & 1);
                if (temp.children[targetBit] != null) {
                    currSum |= 1 << i;
                    temp = temp.children[targetBit];
                } else {
                    temp = temp.children[1 - targetBit];
                }
            }
            max = Math.max(max, currSum);
        }
        return max;
    }

    private TrieNode buildTrie(int[] nums) {
        TrieNode root = new TrieNode();
        for (int num : nums) {
            TrieNode temp = root;
            for (int i = 31; i >= 0; i--) {
                int currBit = (num >> i) & 1;
                if (temp.children[currBit] == null) {
                    temp.children[currBit] = new TrieNode();
                }
                temp = temp.children[currBit];
            }
        }
        return root;
    }

    private static class TrieNode {
        final TrieNode[] children;

        public TrieNode() {
            children = new TrieNode[2];
        }
    }
}
