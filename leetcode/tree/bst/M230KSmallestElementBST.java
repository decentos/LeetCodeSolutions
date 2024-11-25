package tree.bst;

import util.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class M230KSmallestElementBST {

    public int kthSmallest(TreeNode root, int k) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode curr = root;

        while (k > 0) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }

            curr = stack.pop();
            k--;

            if (k == 0) {
                return curr.val;
            }
            curr = curr.right;
        }
        return -1;
    }
}
