package tree;

import util.TreeNode;

public class E700SearchBST {

    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null || root.val == val) return root;
        if (root.val > val) return searchBST(root.left, val);
        return searchBST(root.right, val);
    }

    public TreeNode searchBST2(TreeNode root, int val) {
        while (root != null && root.val != val) {
            if (root.val > val) root = root.left;
            else root = root.right;
        }
        return root;
    }
}
