package tree;

import util.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class E897IncreasingOrderSearchTree {
    private TreeNode curr;

    public TreeNode increasingBST(TreeNode root) {
        TreeNode dummy = new TreeNode(0);
        curr = dummy;
        dfs(root);
        return dummy.right;
    }

    private void dfs(TreeNode node) {
        if (node == null) {
            return;
        }
        dfs(node.left);
        node.left = null;
        curr.right = node;
        curr = curr.right;
        dfs(node.right);
    }

// ===============================================================================

    public TreeNode increasingBST2(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        dfs(root, list);

        TreeNode curr = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            TreeNode right = list.get(i);
            right.left = null;
            curr.right = right;
            curr = curr.right;
        }
        return list.get(0);
    }

    private void dfs(TreeNode node, List<TreeNode> list) {
        if (node == null) {
            return;
        }
        dfs(node.left, list);
        list.add(node);
        dfs(node.right, list);
    }
}
