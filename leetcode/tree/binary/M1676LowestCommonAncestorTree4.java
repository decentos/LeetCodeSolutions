package tree.binary;

import util.TreeNode;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class M1676LowestCommonAncestorTree4 {
    private TreeNode ancestor;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode[] nodes) {
        if (nodes.length == 1) return nodes[0];
        Set<TreeNode> set = new HashSet<>();
        Collections.addAll(set, nodes);
        dfs(root, set);
        return ancestor;
    }

    private void dfs(TreeNode node, Set<TreeNode> set) {
        if (node == null) return;
        dfs(node.left, set);
        dfs(node.right, set);
        set.remove(node.left);
        set.remove(node.right);
        if (set.size() == 1 && set.contains(node)) {
            ancestor = node;
        } else if (set.isEmpty() && ancestor == null) {
            ancestor = node;
        }
    }

    private int dfs2(TreeNode node, Set<TreeNode> set) {
        if (node == null) return 0;
        int left = dfs2(node.left, set);
        int right = dfs2(node.right, set);
        int sum = left + right;
        if (set.contains(node)) sum++;
        if (sum == set.size() && ancestor == null) ancestor = node;
        return sum;
    }

    private TreeNode dfs3(TreeNode node, Set<TreeNode> set) {
        if (node == null) return null;
        if (set.contains(node)) return node;

        TreeNode left = dfs3(node.left, set);
        TreeNode right = dfs3(node.right, set);

        if (left == null) return right;
        if (right == null) return left;
        return node;
    }
}
