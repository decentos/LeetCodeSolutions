package me.decentos.leetcode.tree;

import me.decentos.leetcode.util.TreeNode;

public class E543DiameterBinaryTree {
    private int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        longestPath(root);
        return max;
    }

    private int longestPath(TreeNode node) {
        if (node == null) return 0;
        int left = longestPath(node.left);
        int right = longestPath(node.right);
        max = Math.max(max, left + right);
        return Math.max(left, right) + 1;
    }
}
