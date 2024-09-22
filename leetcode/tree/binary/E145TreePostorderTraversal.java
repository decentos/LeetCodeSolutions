package tree.binary;

import util.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class E145TreePostorderTraversal {
    private final List<Integer> nums = new ArrayList<>();

    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) return nums;
        postorderTraversal(root.left);
        postorderTraversal(root.right);
        nums.add(root.val);
        return nums;
    }
}
