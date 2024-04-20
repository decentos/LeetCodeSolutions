package ntree;

import util.NTreeNode;

import java.util.*;

public class M429NTreeLevelOrderTraversal {

    public List<List<Integer>> levelOrder(NTreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }

        List<List<Integer>> tree = new ArrayList<>();
        Deque<NTreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            tree.add(level);
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                NTreeNode curr = queue.poll();
                level.add(curr.val);

                for (NTreeNode child : curr.children) {
                    queue.offer(child);
                }
            }
        }
        return tree;
    }
}
