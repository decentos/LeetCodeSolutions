package tree.binary;

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

    public List<List<Integer>> zigzagLevelOrder2(TreeNode root) {
        if (root == null) return Collections.emptyList();

        List<List<Integer>> result = new ArrayList<>();
        dfs(root, result, 0);
        return result;
    }

    private void dfs(TreeNode node, List<List<Integer>> result, int level) {
        if (node == null) return;

        if (result.size() <= level) {
            List<Integer> currLevel = new LinkedList<>();
            result.add(currLevel);
        }

        List<Integer> currLevel = result.get(level);
        if (level % 2 == 0) currLevel.add(node.val);
        else currLevel.add(0, node.val);

        dfs(node.left, result, level + 1);
        dfs(node.right, result, level + 1);
    }
}
