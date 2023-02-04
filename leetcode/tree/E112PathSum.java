package tree;

import util.TreeNode;

public class E112PathSum {
    private static boolean isTarget = false;

    public static boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null || root.val > targetSum) return false;
        helper(root, 0, targetSum);
        return isTarget;
    }

    private static void helper(TreeNode root, int sum, int targetSum) {
        if (root == null || isTarget) return;
        sum += root.val;
        if (root.left == null && root.right == null) {
            if (sum == targetSum) isTarget = true;
        }
        helper(root.left, sum, targetSum);
        helper(root.right, sum, targetSum);
    }

    public static boolean hasPathSum2(TreeNode root, int targetSum) {
        if (root == null) return false;
        targetSum -= root.val;
        if (root.left == null && root.right == null) return targetSum == 0;
        return hasPathSum2(root.left, targetSum) || hasPathSum2(root.right, targetSum);
    }
}
