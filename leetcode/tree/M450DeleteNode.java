package tree;

import util.TreeNode;

public class M450DeleteNode {

    public static TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;

        if (root.val > key) {
            root.left = deleteNode(root.left, key);
            return root;
        } else if (root.val < key) {
            root.right = deleteNode(root.right, key);
            return root;
        } else {
            if (root.left == null) return root.right;
            else if (root.right == null) return root.left;

            TreeNode cur = root.right;
            while (cur.left != null) {
                cur = cur.left;
            }
            root.val = cur.val;
            root.right = deleteNode(root.right, cur.val);
            return root;
        }
    }

// ===============================================================================

    public TreeNode deleteNode2(TreeNode root, int key) {
        if (root == null) return null;

        if (key > root.val) root.right = deleteNode2(root.right, key);
        else if (key < root.val) root.left = deleteNode2(root.left, key);
        else {
            if (root.left == null && root.right == null) {
                root = null;
            } else if (root.right != null) {
                root.val = successor(root);
                root.right = deleteNode2(root.right, root.val);
            } else {
                root.val = predecessor(root);
                root.left = deleteNode2(root.left, root.val);
            }
        }
        return root;
    }

    // find the smallest on the right
    private int successor(TreeNode root) {
        root = root.right;
        while (root.left != null) root = root.left;
        return root.val;
    }

    // find the highest on the left
    private int predecessor(TreeNode root) {
        root = root.left;
        while (root.right != null) root = root.right;
        return root.val;
    }

// ===============================================================================

    public TreeNode deleteNode3(TreeNode root, int key) {
        TreeNode curr = root;
        TreeNode prev = null;
        while (curr != null && curr.val != key) {
            prev = curr;
            if (curr.val > key) curr = curr.left;
            else curr = curr.right;
        }

        if (prev == null) return deleteNode(curr);
        if (curr == prev.left) prev.left = deleteNode(curr);
        else prev.right = deleteNode(curr);
        return root;
    }

    private TreeNode deleteNode(TreeNode node) {
        if (node == null) return null;
        if (node.left == null) return node.right;
        if (node.right == null) return node.left;

        TreeNode curr = node.right;
        TreeNode prev = null;
        while (curr.left != null) {
            prev = curr;
            curr = curr.left;
        }
        curr.left = node.left;
        if (node.right != curr) {
            prev.left = curr.right;
            curr.right = node.right;
        }
        return curr;
    }
}
