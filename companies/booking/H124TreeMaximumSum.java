package booking;

import util.TreeNode;

public class H124TreeMaximumSum {
    private int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        pathSum(root);
        return maxSum;
    }

    private int pathSum(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftSum = Math.max(pathSum(node.left), 0);
        int rightSum = Math.max(pathSum(node.right), 0);

        maxSum = Math.max(maxSum, node.val + leftSum + rightSum);

        return Math.max(leftSum, rightSum) + node.val;
    }
}
