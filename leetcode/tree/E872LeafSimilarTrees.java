package tree;

import util.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class E872LeafSimilarTrees {

    public static boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leaves1 = new ArrayList<>();
        List<Integer> leaves2 = new ArrayList<>();
        findLeaf(root1, leaves1);
        findLeaf(root2, leaves2);
        return leaves1.equals(leaves2);
    }

    private static void findLeaf(TreeNode root, List<Integer> leaves) {
        if (root.left != null) findLeaf(root.left, leaves);
        if (root.right != null) findLeaf(root.right, leaves);
        if (root.left == null && root.right == null) leaves.add(root.val);
    }
}
