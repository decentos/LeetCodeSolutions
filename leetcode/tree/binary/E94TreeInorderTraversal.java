package tree.binary;

import util.TreeNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class E94TreeInorderTraversal {
    private final List<Integer> nums = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) return nums;
        inorderTraversal(root.left);
        nums.add(root.val);
        inorderTraversal(root.right);
        return nums;
    }

    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        Set<TreeNode> visited = new HashSet<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            while (stack.peek().left != null && !visited.contains(stack.peek().left)) stack.push(stack.peek().left);
            TreeNode node = stack.pop();
            visited.add(node);
            list.add(node.val);
            if (node.right != null) stack.push(node.right);
        }
        return list;
    }
}
