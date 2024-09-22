package tree.binary;

import util.TreeNode;

import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;

public class M2583KthLargestSum {

    public long kthLargestLevelSum(TreeNode root, int k) {
        Queue<Long> heap = new PriorityQueue<>();
        Queue<TreeNode> levels = new ArrayDeque<>();
        levels.offer(root);

        while (!levels.isEmpty()) {
            long sum = 0;
            int size = levels.size();

            for (int i = 0; i < size; i++) {
                TreeNode node = levels.poll();
                sum += node.val;

                if (node.left != null) levels.offer(node.left);
                if (node.right != null) levels.offer(node.right);
            }

            if (heap.size() < k) {
                heap.offer(sum);
            } else if (heap.peek() < sum) {
                heap.poll();
                heap.offer(sum);
            }
        }

        return heap.size() < k ? -1 : heap.peek();
    }
}
