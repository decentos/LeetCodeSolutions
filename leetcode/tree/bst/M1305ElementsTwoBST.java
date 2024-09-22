package tree.bst;

import util.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class M1305ElementsTwoBST {

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> list = new ArrayList<>();
        traverse(root1, list);
        traverse(root2, list);
        Collections.sort(list);
        return list;
    }

    private void traverse(TreeNode node, List<Integer> list) {
        if (node == null) return;
        traverse(node.left, list);
        list.add(node.val);
        traverse(node.right, list);
    }

// ===============================================================================

    public List<Integer> getAllElements2(TreeNode root1, TreeNode root2) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();

        while (root1 != null || root2 != null || !stack1.isEmpty() || !stack2.isEmpty()) {
            while (root1 != null) {
                stack1.push(root1);
                root1 = root1.left;
            }
            while (root2 != null) {
                stack2.push(root2);
                root2 = root2.left;
            }

            if (stack2.isEmpty() || !stack1.isEmpty() && stack1.peek().val < stack2.peek().val) {
                TreeNode next = stack1.pop();
                list.add(next.val);
                root1 = next.right;
            } else {
                TreeNode next = stack2.pop();
                list.add(next.val);
                root2 = next.right;
            }
        }
        return list;
    }
}
