package tree;

import util.TreeNode;

import java.util.*;

public class M2385AmountTimeBeInfected {

    public int amountOfTime(TreeNode root, int start) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        createGraph(root, 0, graph);
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        int time = -1;
        Set<Integer> visited = new HashSet<>();
        visited.add(start);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int curr = queue.poll();
                for (int adj : graph.get(curr)) {
                    if (!visited.contains(adj)) {
                        queue.offer(adj);
                        visited.add(adj);
                    }
                }
            }
            time++;
        }
        return time;
    }

    private void createGraph(TreeNode node, int parent, Map<Integer, Set<Integer>> graph) {
        Set<Integer> adj = graph.computeIfAbsent(node.val, val -> new HashSet<>());
        if (parent != 0) {
            adj.add(parent);
        }
        if (node.left != null) {
            adj.add(node.left.val);
            createGraph(node.left, node.val, graph);
        }
        if (node.right != null) {
            adj.add(node.right.val);
            createGraph(node.right, node.val, graph);
        }
    }
}
