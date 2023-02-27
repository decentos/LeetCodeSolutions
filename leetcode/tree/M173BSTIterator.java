package tree;

import util.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class M173BSTIterator {
    private final List<Integer> list;
    private int index;

    public M173BSTIterator(TreeNode root) {
        list = new ArrayList<>();
        traverse(root);
    }

    public int next() {
        return list.get(index++);
    }

    public boolean hasNext() {
        return index < list.size();
    }

    private void traverse(TreeNode node) {
        if (node == null) return;
        traverse(node.left);
        list.add(node.val);
        traverse(node.right);
    }
}

class M173BSTIterator2 {
    private final Stack<TreeNode> stack;

    public M173BSTIterator2(TreeNode root) {
        stack = new Stack<>();
        traverse(root);
    }

    public int next() {
        TreeNode next = stack.pop();
        traverse(next.right);
        return next.val;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }

    private void traverse(TreeNode node) {
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }
}
