package tree.binary;

import util.TreeNode;

public class M114FlattenTreeToList {
    private TreeNode curr = null;

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        flatten(root.right);
        flatten(root.left);
        root.right = curr;
        root.left = null;
        curr = root;
    }

// ===============================================================================

    public void flatten2(TreeNode root) {
        if (root == null) {
            return;
        }

        TreeNode curr = root;

        while (curr != null) {
            if (curr.left != null) {
                TreeNode rightmost = curr.left;

                while (rightmost.right != null) {
                    rightmost = rightmost.right;
                }

                rightmost.right = curr.right;
                curr.right = curr.left;
                curr.left = null;
            }
            curr = curr.right;
        }
    }
}
