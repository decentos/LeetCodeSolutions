package ntree;

import util.NTreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class M429NTreeLevelOrderTraversal {

    public List<List<Integer>> levelOrder(NTreeNode root) {
        if (root == null) return Collections.emptyList();

        List<List<Integer>> ans = new ArrayList<>();
        Queue<NTreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                NTreeNode curr = queue.poll();
                level.add(curr.val);
                for (NTreeNode next : curr.children) {
                    queue.offer(next);
                }
            }
            ans.add(level);
        }
        return ans;
    }
}
