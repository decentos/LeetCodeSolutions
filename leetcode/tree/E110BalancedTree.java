package tree;

import util.TreeNode;

public class E110BalancedTree {

    public static boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        return Math.abs(height(root.left) - height(root.right)) < 2
                && isBalanced(root.left)
                && isBalanced(root.right);
    }
    private static int height(TreeNode root) {
        if (root == null) return -1;
        return Math.max(height(root.left), height(root.right)) + 1;
    }

    private static boolean isBalanced = true;
    public static boolean isBalanced2(TreeNode root) {
        helper(root, 0);
        return isBalanced;
    }
    private static int helper(TreeNode root, int sum) {
        if (root == null) return sum;
        int left = helper(root.left, sum);
        int right = helper(root.right, sum);
        if (Math.abs(left - right) > 1) isBalanced = false;
        if (left == 0 && right == 0) return sum + 1;
        else return Math.max(left, right) + 1;
    }
}
