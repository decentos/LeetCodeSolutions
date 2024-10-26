package tree.bst;

import util.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class M230KSmallestElementBST {

    public int kthSmallest(TreeNode root, int k) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode node = root;
        int index = 0;

        while (index < k) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            index++;
            if (index == k) {
                return node.val;
            }
            node = node.right;
        }
        return -1;
    }
}
