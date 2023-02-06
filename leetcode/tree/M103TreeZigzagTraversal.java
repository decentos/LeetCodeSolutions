package tree;

import util.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class M103TreeZigzagTraversal {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) return Collections.emptyList();

        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            List<Integer> currValues = new ArrayList<>();
            List<TreeNode> currNodes = new ArrayList<>();
            while (!queue.isEmpty()) {
                TreeNode next = queue.poll();
                if (next != null) {
                    currValues.add(next.val);
                    currNodes.add(next);
                }
            }
            if (result.size() % 2 == 1) Collections.reverse(currValues);
            if (currValues.size() > 0) result.add(currValues);
            currNodes.forEach(node -> {
                queue.offer(node.left);
                queue.offer(node.right);
            });
        }
        return result;
    }
}
