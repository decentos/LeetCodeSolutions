package tree;

import util.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class E872LeafSimilarTrees {

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leaf1 = new ArrayList<>();
        List<Integer> leaf2 = new ArrayList<>();
        traverse(root1, leaf1);
        traverse(root2, leaf2);
        return leaf1.equals(leaf2);
    }

    private void traverse(TreeNode node, List<Integer> leaf) {
        if (node == null) {
            return;
        } else if (node.left == null && node.right == null) {
            leaf.add(node.val);
            return;
        }
        traverse(node.left, leaf);
        traverse(node.right, leaf);
    }
}
