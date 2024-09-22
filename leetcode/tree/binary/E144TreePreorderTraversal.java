package tree.binary;

import util.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class E144TreePreorderTraversal {
    private final List<Integer> nums = new ArrayList<>();

    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) return nums;
        nums.add(root.val);
        preorderTraversal(root.left);
        preorderTraversal(root.right);
        return nums;
    }
}
