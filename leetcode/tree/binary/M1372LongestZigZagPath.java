package tree.binary;

import util.TreeNode;

public class M1372LongestZigZagPath {

    private int max;

    public int longestZigZag(TreeNode root) {
        dfs(root.left, true, 1);
        dfs(root.right, false, 1);
        return max;
    }

    private void dfs(TreeNode node, boolean isLeft, int path) {
        if (node == null) {
            return;
        }

        max = Math.max(max, path);

        if (isLeft) {
            dfs(node.left, true, 1);
            dfs(node.right, false, path + 1);
        } else {
            dfs(node.left, true, path + 1);
            dfs(node.right, false, 1);
        }
    }
}
