package tree.binary;

import util.TreeNode;

import java.util.*;

public class M103TreeZigzagTraversal {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }

        List<List<Integer>> levels = new ArrayList<>();
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        boolean isEven = true;

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();

                if (isEven) {
                    level.add(curr.val);
                } else {
                    level.addFirst(curr.val);
                }

                if (curr.left != null) {
                    queue.offer(curr.left);
                }
                if (curr.right != null) {
                    queue.offer(curr.right);
                }
            }
            isEven = !isEven;
            levels.add(level);
        }
        return levels;
    }

// ===============================================================================

    public List<List<Integer>> zigzagLevelOrderDFS(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }

        List<List<Integer>> levels = new ArrayList<>();
        dfs(root, levels, 0);
        return levels;
    }

    private void dfs(TreeNode node, List<List<Integer>> levels, int level) {
        if (node == null) {
            return;
        }

        if (levels.size() <= level) {
            levels.add(new ArrayList<>());
        }

        List<Integer> currLevel = levels.get(level);
        if (level % 2 == 0) {
            currLevel.add(node.val);
        } else {
            currLevel.addFirst(node.val);
        }

        dfs(node.left, levels, level + 1);
        dfs(node.right, levels, level + 1);
    }
}
