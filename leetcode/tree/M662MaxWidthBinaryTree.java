package tree;

import util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class M662MaxWidthBinaryTree {

    public int widthOfBinaryTree(TreeNode root) {
        int max = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            int left = 0, right = 0;

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                if (left == 0) left = node.val;
                if (i == size - 1) right = node.val;

                if (node.left != null) {
                    node.left.val = 2 * node.val + 1;
                    queue.offer(node.left);
                }

                if (node.right != null) {
                    node.right.val = 2 * node.val + 2;
                    queue.offer(node.right);
                }
            }
            max = Math.max(max, right - left + 1);
        }
        return max;
    }
}
