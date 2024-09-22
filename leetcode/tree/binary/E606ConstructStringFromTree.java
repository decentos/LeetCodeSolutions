package tree.binary;

import util.TreeNode;

public class E606ConstructStringFromTree {

    public String tree2str(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        dfs(root, sb);
        return sb.toString();
    }

    private void dfs(TreeNode node, StringBuilder sb) {
        if (node == null) {
            return;
        }
        sb.append(node.val);
        if (node.left == null && node.right == null) {
            return;
        }
        sb.append("(");
        dfs(node.left, sb);
        sb.append(")");
        if (node.right != null) {
            sb.append("(");
            dfs(node.right, sb);
            sb.append(")");
        }
    }
}
