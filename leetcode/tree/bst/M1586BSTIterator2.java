package tree.bst;

import util.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class M1586BSTIterator2 {

    private static class BSTIterator {
        private final List<Integer> list;
        private int index;

        public BSTIterator(TreeNode root) {
            list = new ArrayList<>();
            index = -1;
            traverse(root);
        }

        public boolean hasNext() {
            return index + 1 < list.size();
        }

        public int next() {
            return list.get(++index);
        }

        public boolean hasPrev() {
            return index > 0;
        }

        public int prev() {
            return list.get(--index);
        }

        private void traverse(TreeNode node) {
            if (node == null) return;
            traverse(node.left);
            list.add(node.val);
            traverse(node.right);
        }
    }

    private static class BSTIterator2 {
        private final Stack<TreeNode> stack;
        private final List<Integer> list;
        private int index;
        private TreeNode node;

        public BSTIterator2(TreeNode root) {
            stack = new Stack<>();
            list = new ArrayList<>();
            index = -1;
            node = root;
        }

        public boolean hasNext() {
            return !stack.isEmpty() || node != null || index + 1 < list.size();
        }

        public int next() {
            index++;
            if (index == list.size()) {
                while (node != null) {
                    stack.push(node);
                    node = node.left;
                }
                TreeNode curr = stack.pop();
                list.add(curr.val);
                node = curr.right;
            }
            return list.get(index);
        }

        public boolean hasPrev() {
            return index > 0;
        }

        public int prev() {
            return list.get(--index);
        }
    }
}
