package tree;

import util.TreeNode;

import java.util.HashSet;
import java.util.Set;

public class M1214TwoSumTwoBST {

    public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
        Set<Integer> set = new HashSet<>();
        traverse(root1, set);
        return findTarget(root2, set, target);
    }

    private void traverse(TreeNode node, Set<Integer> set) {
        if (node == null) return;
        set.add(node.val);
        traverse(node.left, set);
        traverse(node.right, set);
    }

    private boolean findTarget(TreeNode node, Set<Integer> set, int target) {
        if (node == null) return false;
        if (set.contains(target - node.val)) return true;
        return findTarget(node.left, set, target) || findTarget(node.right, set, target);
    }
}
