package me.decentos.leetcode.tree;

import me.decentos.leetcode.util.TreeNode;

public class M129SumRootLeaf {
    private int sum = 0;

    public int sumNumbers(TreeNode root) {
        helper(root, 0);
        return sum;
    }

    private void helper(TreeNode root, int current) {
        if (root == null) return;
        current = current * 10 + root.val;
        if (root.left == null && root.right == null) sum += current;
        helper(root.left, current);
        helper(root.right, current);
    }
}
