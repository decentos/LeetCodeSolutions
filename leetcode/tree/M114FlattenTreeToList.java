package tree;

import util.TreeNode;

public class M114FlattenTreeToList {
    private TreeNode last = null;

    public void flatten(TreeNode root) {
        if (root == null) return;
        flatten(root.right);
        flatten(root.left);
        root.right = last;
        root.left = null;
        last = root;
    }

    public void flatten2(TreeNode root) {
        if (root == null) return;

        TreeNode node = root;
        while (node != null) {
            if (node.left != null) {
                TreeNode rightmost = node.left;
                while (rightmost.right != null) rightmost = rightmost.right;

                rightmost.right = node.right;
                node.right = node.left;
                node.left = null;
            }
            node = node.right;
        }
    }
}
