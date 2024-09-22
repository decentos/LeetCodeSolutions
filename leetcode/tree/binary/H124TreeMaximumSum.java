package tree.binary;

import util.TreeNode;

public class H124TreeMaximumSum {
    private static int maxSum = Integer.MIN_VALUE;

    public static int maxPathSum(TreeNode root) {
        getSum(root);
        return maxSum;
    }

    private static int getSum(TreeNode root) {
        if (root == null) return 0;
        int leftSum = Math.max(getSum(root.left), 0);
        int rightSum = Math.max(getSum(root.right), 0);
        maxSum = Math.max(maxSum, root.val + leftSum + rightSum);
        return Math.max(leftSum + root.val, rightSum + root.val);
    }
}
