package tree;

import util.TreeNode;

public class M1457PalindromicPathsTree {

    public int pseudoPalindromicPaths (TreeNode root) {
        return dfs(root, new int[10]);
    }

    private int dfs(TreeNode node, int[] path) {
        if (node == null) {
            return 0;
        }
        path[node.val]++;

        if (node.left == null && node.right == null) {
            boolean isPalindromic = isPalindromic(path);
            path[node.val]--;
            return isPalindromic ? 1 : 0;
        }

        int count = 0;
        count += dfs(node.left, path);
        count += dfs(node.right, path);
        path[node.val]--;
        return count;
    }

    private boolean isPalindromic(int[] path) {
        boolean hasOdd = false;
        boolean isPalindromic = true;
        for (int i : path) {
            if (i > 0) {
                if (i % 2 != 0 && !hasOdd) {
                    hasOdd = true;
                } else if (i % 2 != 0) {
                    isPalindromic = false;
                    break;
                }
            }
        }
        return isPalindromic;
    }
}
