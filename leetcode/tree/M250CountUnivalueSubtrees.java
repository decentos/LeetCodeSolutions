package tree;

import util.TreeNode;

public class M250CountUnivalueSubtrees {
    private int count = 0;

    public int countUnivalSubtrees(TreeNode root) {
        if (root == null) return 0;
        counter(root);
        return count;
    }

    private int counter(TreeNode node) {
        int left = node.left == null ? node.val : counter(node.left);
        int right = node.right == null ? node.val : counter(node.right);

        if (left == right && left == node.val) {
            count++;
            return node.val;
        }
        return -1001;
    }

    private boolean isUni(TreeNode node) {
        if (node.left == null && node.right == null) {
            count++;
            return true;
        }
        boolean isUniVal = true;
        if (node.left != null) {
            isUniVal = isUni(node.left) && node.left.val == node.val;
        }
        if (node.right != null) {
            isUniVal = isUni(node.right) && isUniVal && node.right.val == node.val;
        }
        if (isUniVal) {
            count++;
            return true;
        }
        return false;
    }

    private boolean isUni(TreeNode node, int val) {
        if (node == null) return true;

        boolean isUniLeft = isUni(node.left, node.val);
        boolean isUniRight = isUni(node.right, node.val);

        if (isUniLeft && isUniRight) {
            count++;
            return val == node.val;
        }
        return false;
    }
}
