package tree;

import util.TreeNode;

public class M235LowestCommonAncestorBST {

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val < root.val && q.val < root.val) return lowestCommonAncestor(root.left, p, q);
        else if (p.val > root.val && q.val > root.val) return lowestCommonAncestor(root.right, p, q);
        else return root;
    }

    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null) {
            if (root.val > p.val && root.val > q.val) root = root.left;
            else if (root.val < p.val && root.val < q.val) root = root.right;
            else return root;
        }
        return null;
    }
}
