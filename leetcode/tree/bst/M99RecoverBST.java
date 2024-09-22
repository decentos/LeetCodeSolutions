package tree.bst;

import util.TreeNode;

public class M99RecoverBST {
    private TreeNode a = null, b = null, prev = null;

    public void recoverTree(TreeNode root) {
        dfs(root);
        swap(a, b);
    }

    private void dfs(TreeNode node) {
        if (node == null) return;
        dfs(node.left);

        if (prev != null && a == null && prev.val > node.val) {
            a = prev;
        }
        if (a != null && prev.val > node.val) {
            b = node;
        }
        prev = node;

        dfs(node.right);
    }

    private void swap(TreeNode a, TreeNode b) {
        int temp = a.val;
        a.val = b.val;
        b.val = temp;
    }
}
