package tree;

import util.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class E94TreeInorderTraversal {
    private final List<Integer> nums = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) return nums;
        inorderTraversal(root.left);
        nums.add(root.val);
        inorderTraversal(root.right);
        return nums;
    }
}
