package tree;

import util.TreeNode;

public class M426ConvertBSTToSortedDoublyList {
    private TreeNode first = null;
    private TreeNode last = null;

    public TreeNode treeToDoublyList(TreeNode root) {
        if (root == null) return null;
        dfs(root);
        first.left = last;
        last.right = first;
        return first;
    }

    private void dfs(TreeNode node) {
        if (node == null) return;
        dfs(node.left);
        if (last == null) {
            first = node;
        } else {
            last.right = node;
            node.left = last;
        }
        last = node;
        dfs(node.right);
    }
}
