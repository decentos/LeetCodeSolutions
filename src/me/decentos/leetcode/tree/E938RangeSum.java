package me.decentos.leetcode.tree;

import me.decentos.leetcode.util.TreeNode;

import java.util.Stack;

public class E938RangeSum {
    private static int sum = 0;

    public static int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) return sum;
        if (root.val >= low && root.val <= high) sum += root.val;
        if (low < root.val) rangeSumBST(root.left, low, high);
        if (root.val < high) rangeSumBST(root.right, low, high);
        return sum;
    }

    public int rangeSumBST2(TreeNode root, int low, int high) {
        int sum = 0;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.empty()) {
            TreeNode current = stack.pop();
            if (current == null) continue;
            if (current.val >= low && current.val <= high) sum += current.val;
            if (low < current.val) stack.push(current.left);
            if (current.val < high) stack.push(current.right);
        }
        return sum;
    }
}
