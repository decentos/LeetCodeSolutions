package tree.binary;

import util.TreeNode;

public class M979DistributeCoins {
    private int moves;

    public int distributeCoins(TreeNode root) {
        dfs(root);
        return moves;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = dfs(root.left);
        int right = dfs(root.right);

        moves += Math.abs(left) + Math.abs(right);

        return root.val - 1 + left + right;
    }
}
