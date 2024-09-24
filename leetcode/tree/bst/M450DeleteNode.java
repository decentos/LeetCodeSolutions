package tree.bst;

import util.TreeNode;

public class M450DeleteNode {

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }

        if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else if (root.val < key) {
            root.right = deleteNode(root.right, key);
        } else {
            if (root.left == null && root.right == null) {
                return null;
            } else if (root.right != null) {
                root.val = findNext(root);
                root.right = deleteNode(root.right, root.val);
            } else {
                root.val = findPrev(root);
                root.left = deleteNode(root.left, root.val);
            }
        }
        return root;
    }

    private int findNext(TreeNode node) {
        node = node.right;
        while (node.left != null) {
            node = node.left;
        }
        return node.val;
    }

    private int findPrev(TreeNode node) {
        node = node.left;
        while (node.right != null) {
            node = node.right;
        }
        return node.val;
    }
}
