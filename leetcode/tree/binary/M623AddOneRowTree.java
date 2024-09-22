package tree.binary;

import util.TreeNode;

public class M623AddOneRowTree {

    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (depth == 1) {
            TreeNode node = new TreeNode(val);
            node.left = root;
            return node;
        }

        dfs(root, val, 1, depth);
        return root;
    }

    private void dfs(TreeNode node, int val, int level, int depth) {
        if (node == null) {
            return;
        } else if (level == depth - 1) {
            TreeNode currLeft = new TreeNode(val);
            TreeNode currRight = new TreeNode(val);

            currLeft.left = node.left;
            node.left = currLeft;

            currRight.right = node.right;
            node.right = currRight;
            return;
        }
        dfs(node.left, val, level + 1, depth);
        dfs(node.right, val, level + 1, depth);
    }
}
