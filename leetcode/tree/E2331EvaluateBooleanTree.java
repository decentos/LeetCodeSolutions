package tree;

import util.TreeNode;

public class E2331EvaluateBooleanTree {

    public boolean evaluateTree(TreeNode root) {
        if (root.left == null && root.right == null) {
            return root.val == 1;
        }

        boolean left = evaluateTree(root.left);
        boolean right = evaluateTree(root.right);

        return root.val == 2 ? left || right : left && right;
    }
}
