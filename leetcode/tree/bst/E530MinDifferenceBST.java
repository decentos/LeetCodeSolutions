package tree.bst;

import util.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class E530MinDifferenceBST {
    private int minDiff = Integer.MAX_VALUE;
    private TreeNode prev;

    public int getMinimumDifference(TreeNode root) {
        dfs(root);
        return minDiff;
    }

    private void dfs(TreeNode node) {
        if (node == null) {
            return;
        }
        dfs(node.left);

        if (prev != null) {
            minDiff = Math.min(minDiff, node.val - prev.val);
        }
        prev = node;

        dfs(node.right);
    }

// ===============================================================================

    public int getMinimumDifference2(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        int minDiff = Integer.MAX_VALUE;

        TreeNode prev = null;
        TreeNode curr = root;

        while (!stack.isEmpty() || curr != null) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }

            curr = stack.pop();
            if (prev != null) {
                minDiff = Math.min(minDiff, curr.val - prev.val);
            }
            prev = curr;
            curr = curr.right;
        }
        return minDiff;
    }
}
