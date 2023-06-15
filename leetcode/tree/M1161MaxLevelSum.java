package tree;

import util.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

public class M1161MaxLevelSum {

    public int maxLevelSum(TreeNode root) {
        int maxSum = Integer.MIN_VALUE, minLevel = 0, currLevel = 0;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            currLevel++;
            int size = queue.size();
            int currSum = 0;

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                currSum += node.val;

                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }

            if (currSum > maxSum) {
                maxSum = currSum;
                minLevel = currLevel;
            }
        }
        return minLevel;
    }
}
