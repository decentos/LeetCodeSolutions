package tree;

import util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class M513FindBottomLeftValue {

    public int findBottomLeftValue(TreeNode root) {
        int leftmost = -1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            leftmost = queue.peek().val;
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                if (curr.left != null) {
                    queue.offer(curr.left);
                }
                if (curr.right != null) {
                    queue.offer(curr.right);
                }
            }
        }
        return leftmost;
    }
}
