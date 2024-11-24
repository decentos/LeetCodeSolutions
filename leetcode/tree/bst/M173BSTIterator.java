package tree.bst;

import util.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class M173BSTIterator {

    private static class BSTIterator {
        private final Deque<TreeNode> stack;

        public BSTIterator(TreeNode root) {
            stack = new ArrayDeque<>();
            leftmost(root);
        }

        public int next() {
            TreeNode next = stack.pop();

            if (next.right != null) {
                leftmost(next.right);
            }

            return next.val;
        }

        public boolean hasNext() {
            return !stack.isEmpty();
        }

        private void leftmost(TreeNode node) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
        }
    }
}
