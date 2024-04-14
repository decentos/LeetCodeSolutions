package tree;

import util.TreeNode;

public class E404SumLeftLeaves {

    public int sumOfLeftLeaves(TreeNode root) {
        return dfs(root, false);
    }

    private int dfs(TreeNode node, boolean isLeft) {
        if (node == null) {
            return 0;
        }
        if (isLeft && node.left == null && node.right == null) {
            return node.val;
        }
        return dfs(node.left, true) + dfs(node.right, false);
    }
}
