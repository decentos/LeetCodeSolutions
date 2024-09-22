package tree.bst;

import util.TreeNode;

import java.util.HashSet;
import java.util.Set;

public class E653TwoSum4InputBST {

    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> set = new HashSet<>();
        return traverse(root, set, k);
    }

    private boolean traverse(TreeNode node, Set<Integer> set, int target) {
        if (node == null) return false;
        if (set.contains(target - node.val)) return true;

        set.add(node.val);
        return traverse(node.left, set, target) || traverse(node.right, set, target);
    }
}
