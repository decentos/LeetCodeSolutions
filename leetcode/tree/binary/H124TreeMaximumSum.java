package tree.binary;

import util.TreeNode;

public class H124TreeMaximumSum {
    private int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        getSum(root);
        return max;
    }

    private int getSum(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int left = Math.max(getSum(node.left), 0);
        int right = Math.max(getSum(node.right), 0);

        max = Math.max(max, node.val + left + right);
        return Math.max(left, right) + node.val;
    }
}
