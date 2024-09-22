package tree.binary;

import util.TreeNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class M366FindLeavesBinaryTree {

    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> leaves = new LinkedList<>();
        Set<TreeNode> used = new HashSet<>();

        while (!used.contains(root)) {
            List<Integer> curr = new ArrayList<>();
            dfs(curr, root, used);
            leaves.add(curr);
        }
        return leaves;
    }

    private void dfs(List<Integer> curr, TreeNode node, Set<TreeNode> used) {
        if (node == null || used.contains(node)) return;

        if ((node.left == null || used.contains(node.left)) && (node.right == null || used.contains(node.right))) {
            curr.add(node.val);
            used.add(node);
            return;
        }

        dfs(curr, node.left, used);
        dfs(curr, node.right, used);
    }

// ===============================================================================

    public List<List<Integer>> findLeaves2(TreeNode root) {
        List<List<Integer>> leaves = new ArrayList<>();
        getHeight(leaves, root);
        return leaves;
    }

    private int getHeight(List<List<Integer>> leaves, TreeNode node) {
        if (node == null) return -1;

        int leftHeight = getHeight(leaves, node.left);
        int rightHeight = getHeight(leaves, node.right);
        int height = 1 + Math.max(leftHeight, rightHeight);

        if (leaves.size() == height) {
            leaves.add(new ArrayList<>());
        }
        leaves.get(height).add(node.val);
        return height;
    }
}
