package tree.binary;

import util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class M958CompletenessBinaryTree {

    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean hasNull = false;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                if (node.left == null && node.right != null) return false;
                if (node.left != null && hasNull) return false;
                if (node.right == null) hasNull = true;

                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
        }
        return true;
    }

    public boolean isCompleteTree2(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean hasNull = false;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                if (node == null) {
                    hasNull = true;
                    continue;
                }
                if (hasNull) return false;

                queue.offer(node.left);
                queue.offer(node.right);
            }
        }
        return true;
    }
}
