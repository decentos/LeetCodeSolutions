package tree;

import util.TreeNode;

public class M236LowestCommonAncestorTree {
    private TreeNode answer;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        findAncestor(root, p, q);
        return answer;
    }

    private boolean findAncestor(TreeNode node, TreeNode p, TreeNode q) {
        if (node == null) return false;

        int curr = (node == p || node == q) ? 1 : 0;
        int left = findAncestor(node.left, p, q) ? 1 : 0;
        int right = findAncestor(node.right, p, q) ? 1 : 0;
        int sum = curr + left + right;

        if (sum > 1) answer = node;
        return sum > 0;
    }

// ===============================================================================

    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor2(root.left, p, q);
        TreeNode right = lowestCommonAncestor2(root.right, p, q);
        if (left == null) return right;
        if (right == null) return left;
        return root;
    }
}
