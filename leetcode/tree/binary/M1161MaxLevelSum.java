package tree.binary;

import util.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class M1161MaxLevelSum {

    public int maxLevelSum(TreeNode root) {
        int maxSum = Integer.MIN_VALUE, level = 0, currLevel = 1;
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int currSum = 0;
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                currSum += curr.val;
                if (curr.left != null) {
                    queue.offer(curr.left);
                }
                if (curr.right != null) {
                    queue.offer(curr.right);
                }
            }

            if (currSum > maxSum) {
                maxSum = currSum;
                level = currLevel;
            }
            currLevel++;
        }
        return level;
    }
}
