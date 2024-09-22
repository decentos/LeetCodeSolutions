package tree.binary;

import util.TreeNode;

public class M1644LowestCommonAncestorTree2 {
    private TreeNode answer;
    private boolean hasP, hasQ;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        findAncestor(root, p, q);
        if (hasP && hasQ) return answer;
        return null;
    }

    private boolean findAncestor(TreeNode node, TreeNode p, TreeNode q) {
        if (node == null) return false;

        int curr = 0;
        if (node == p) {
            curr++;
            hasP = true;
        } else if (node == q) {
            curr++;
            hasQ = true;
        }
        int left = findAncestor(node.left, p, q) ? 1 : 0;
        int right = findAncestor(node.right, p, q) ? 1 : 0;
        int sum = curr + left + right;

        if (sum > 1) answer = node;
        return sum > 0;
    }

// ===============================================================================

    private int count;

    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode ancestor = findAncestor2(root, p, q);
        return count == 2 ? ancestor : null;
    }

    private TreeNode findAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        TreeNode left = findAncestor2(root.left, p, q);
        TreeNode right = findAncestor2(root.right, p, q);

        if (root == p || root == q) {
            count++;
            return root;
        }
        if (left == null) return right;
        if (right == null) return left;
        return root;
    }
}
