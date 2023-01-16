package me.decentos.leetcode.tree;

import me.decentos.leetcode.util.TreeNode;

public class M1026MaximumDifference {
    static int result = 0;

    public static int maxAncestorDiff(TreeNode root) {
        findMaxDiff(root, root.val, root.val);
        return result;
    }

    private static void findMaxDiff(TreeNode root, int max, int min) {
        if (root == null) return;
        int curDiff = Math.max(Math.abs(max - root.val), Math.abs(min - root.val));
        result = Math.max(result, curDiff);
        max = Math.max(max, root.val);
        min = Math.min(min, root.val);
        findMaxDiff(root.left, max, min);
        findMaxDiff(root.right, max, min);
    }

    public static int maxAncestorDiff2(TreeNode root) {
        return findMaxDiff2(root, root.val, root.val);
    }

    private static int findMaxDiff2(TreeNode root, int max, int min) {
        if (root == null) return max - min;
        max = Math.max(max, root.val);
        min = Math.min(min, root.val);
        int left = max = findMaxDiff2(root.left, max, min);
        int right = findMaxDiff2(root.right, max, min);
        return Math.max(left, right);
    }
}
