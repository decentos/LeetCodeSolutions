package tree;

import util.TreeNode;

import java.util.Stack;

public class M1008ConstructTreePreorder {

    public TreeNode bstFromPreorder(int[] preorder) {
        TreeNode root = new TreeNode(preorder[0]);
        for (int i = 1; i < preorder.length; i++) {
            dfs(root, preorder[i]);
        }
        return root;
    }

    private void dfs(TreeNode node, int val) {
        if (node.val > val) {
            if (node.left == null) {
                node.left = new TreeNode(val);
            } else {
                dfs(node.left, val);
            }
        } else {
            if (node.right == null) {
                node.right = new TreeNode(val);
            } else {
                dfs(node.right, val);
            }
        }
    }

    public TreeNode bstFromPreorder2(int[] preorder) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode root = new TreeNode(preorder[0]);
        stack.push(root);
        for (int i = 1; i < preorder.length; i++) {
            TreeNode node = new TreeNode(preorder[i]);
            if (stack.peek().val > node.val) {
                stack.peek().left = node;
            } else {
                TreeNode parent = stack.peek();
                while (!stack.isEmpty() && node.val > stack.peek().val) {
                    parent = stack.pop();
                }
                parent.right = node;
            }
            stack.push(node);
        }
        return root;
    }
}
