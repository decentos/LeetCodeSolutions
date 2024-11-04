package tree.bst;

import util.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class M230KSmallestElementBST {

    public int kthSmallest(TreeNode root, int k) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode node = root;

        while (k > 0) {
            k--;
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();

            if (k == 0) {
                return node.val;
            }

            node = node.right;
        }
        return -1;
    }
}
