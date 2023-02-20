package tree;

import util.TreeNode;

public class M236LowestCommonAncestorTree {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null) {
            boolean hasLeftP = findNode(root.left, p.val);
            boolean hasLeftQ = findNode(root.left, q.val);
            if (hasLeftP && hasLeftQ) {
                root = root.left;
                continue;
            }
            boolean hasRightP = findNode(root.right, p.val);
            boolean hasRightQ = findNode(root.right, q.val);
            if (hasRightP && hasRightQ) {
                root = root.right;
                continue;
            }
            return root;
        }
        return null;
    }

    private boolean findNode(TreeNode node, int target) {
        if (node == null) return false;
        if (node.val == target) return true;
        return findNode(node.left, target) || findNode(node.right, target);
    }

// ===============================================================================

    private TreeNode answer;

    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
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

    public TreeNode lowestCommonAncestor3(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null && right == null) return null;
        if (left != null && right != null) return root;
        return left == null ? right : left;
    }
}
