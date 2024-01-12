package tree;

import util.TreeNode;

public class M1026MaximumDifference {
    public int maxAncestorDiff(TreeNode root) {
        return findMax(root, root.val, root.val);
    }

    private int findMax(TreeNode node, int max, int min) {
        if (node == null) {
            return max - min;
        }
        max = Math.max(max, node.val);
        min = Math.min(min, node.val);
        int left = findMax(node.left, max, min);
        int right = findMax(node.right, max, min);
        return Math.max(left, right);
    }
}
