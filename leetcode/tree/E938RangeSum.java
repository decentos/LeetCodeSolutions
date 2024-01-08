package tree;

import util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class E938RangeSum {

    public int rangeSumBST(TreeNode root, int low, int high) {
        int sum = 0;
        if (root.val >= low && root.val <= high) {
            sum += root.val;
        }
        if (root.left != null && root.val > low) {
            sum += rangeSumBST(root.left, low, high);
        }
        if (root.right != null && root.val < high) {
            sum += rangeSumBST(root.right, low, high);
        }
        return sum;
    }

    public int rangeSumBST2(TreeNode root, int low, int high) {
        int sum = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.val >= low && node.val <= high) {
                sum += node.val;
            }
            if (node.left != null && node.val > low) {
                queue.offer(node.left);
            }
            if (node.right != null && node.val < high) {
                queue.offer(node.right);
            }
        }
        return sum;
    }
}
