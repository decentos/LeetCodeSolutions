package tree;

import util.TreeNode;

public class E111MinDepth {
    private int min = Integer.MAX_VALUE;

    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        helper(root, 1);
        return min;
    }

    private int helper(TreeNode root, int sum) {
        if (root == null) return sum;
        if (root.left == null && root.right == null) {
            min = Math.min(min, sum);
            return sum;
        }
        sum++;
        int left = helper(root.left, sum);
        int right = helper(root.right, sum);
        if (left == 0 && right == 0) return sum + 1;
        else return Math.max(left, right) + 1;
    }

    public int minDepth2(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null) return minDepth2(root.right) + 1;
        if (root.right == null) return minDepth2(root.left) + 1;
        return Math.min(minDepth2(root.left), minDepth2(root.right)) + 1;
    }

    public int minDepth3(TreeNode root) {
        if (root == null) return 0;
        int left = minDepth3(root.left);
        int right = minDepth3(root.right);
        return (left == 0 || right == 0) ? left + right + 1 : Math.min(left, right) + 1;
    }
}
