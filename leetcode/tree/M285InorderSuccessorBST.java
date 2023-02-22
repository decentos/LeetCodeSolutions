package tree;

import util.TreeNode;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class M285InorderSuccessorBST {

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode successor = null;
        while (root != null) {
            if (root.val > p.val) {
                successor = root;
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return successor;
    }

    public TreeNode inorderSuccessor2(TreeNode root, TreeNode p) {
        Stack<TreeNode> stack = new Stack<>();
        Set<TreeNode> seen = new HashSet<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            while (stack.peek().left != null && !seen.contains(stack.peek().left)) stack.push(stack.peek().left);
            TreeNode node = stack.pop();
            seen.add(node);
            if (node.right != null) stack.push(node.right);
            if (node.val == p.val) {
                if (stack.isEmpty()) return null;
                else {
                    while (stack.peek().left != null && !seen.contains(stack.peek().left)) stack.push(stack.peek().left);
                    return stack.pop();
                }
            }
        }
        return null;
    }

    public TreeNode inorderSuccessor3(TreeNode root, TreeNode p) {
        boolean isSourceNode = false;
        Stack<TreeNode> stack = new Stack<>();

        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (isSourceNode) return root;
            if (root.val == p.val) isSourceNode = true;
            root = root.right;
        }
        return null;
    }

// ===============================================================================

    public TreeNode inorderSuccessor4(TreeNode root, TreeNode p) {
        if (root == null) return null;

        if (root.val <= p.val) {
            return inorderSuccessor4(root.right, p);
        } else {
            TreeNode left = inorderSuccessor4(root.left, p);
            return left != null ? left : root;
        }
    }

    public TreeNode predecessor(TreeNode root, TreeNode p) {
        if (root == null) return null;

        if (root.val >= p.val) {
            return predecessor(root.left, p);
        } else {
            TreeNode right = predecessor(root.right, p);
            return right != null ? right : root;
        }
    }
}
