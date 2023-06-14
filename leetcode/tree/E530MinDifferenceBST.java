package tree;

import util.TreeNode;

public class E530MinDifferenceBST {
    private int min = Integer.MAX_VALUE;
    private TreeNode prev = null;

    public int getMinimumDifference(TreeNode root) {
        traverse(root);
        return min;
    }

    private void traverse(TreeNode node) {
        if (node == null) return;

        traverse(node.left);

        if (prev != null) {
            min = Math.min(min, node.val - prev.val);
        }
        prev = node;

        traverse(node.right);
    }
}
