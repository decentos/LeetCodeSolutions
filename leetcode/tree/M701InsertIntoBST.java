package tree;

import util.TreeNode;

public class M701InsertIntoBST {

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        TreeNode curr = root;
        TreeNode prev = curr;

        while (curr != null) {
            prev = curr;
            if (curr.val > val) curr = curr.left;
            else curr = curr.right;
        }

        if (prev.val > val) prev.left = new TreeNode(val);
        else prev.right = new TreeNode(val);
        return root;
    }

    public TreeNode insertIntoBST2(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        if (root.val > val) root.left = insertIntoBST2(root.left, val);
        else root.right = insertIntoBST2(root.right, val);
        return root;
    }
}
