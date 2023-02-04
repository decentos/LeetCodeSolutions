package tree;

import util.TreeNode;

public class E270ClosestValue {
    private double minDiff = Integer.MAX_VALUE;
    private int closest = Integer.MAX_VALUE;

    public int closestValue(TreeNode root, double target) {
        helper(root, target);
        return closest;
    }

    private void helper(TreeNode node, double target) {
        if (node == null) return;
        double curDiff = Math.abs(node.val - target);
        if (curDiff < minDiff) {
            minDiff = curDiff;
            closest = node.val;
        }
        if (node.val > target) helper(node.left, target);
        else helper(node.right, target);
    }
}
