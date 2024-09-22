package tree.binary;

import util.TreeNode;

public class E543DiameterBinaryTree {
    private int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return max;
    }

    private int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = dfs(node.left);
        int right = dfs(node.right);
        max = Math.max(max, left + right);
        return Math.max(left, right) + 1;
    }
}
