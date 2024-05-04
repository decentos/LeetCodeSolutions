package graph.topologicalsort;

import java.util.*;

public class M310MinHeightTrees {

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> roots = new ArrayList<>();
        if (n < 2) {
            for (int i = 0; i < n; i++) {
                roots.add(i);
            }
            return roots;
        }
        int[] inDegree = new int[n];
        Map<Integer, List<Integer>> adj = new HashMap<>();

        for (int[] edge : edges) {
            inDegree[edge[0]]++;
            inDegree[edge[1]]++;
            adj.computeIfAbsent(edge[0], val -> new ArrayList<>()).add(edge[1]);
            adj.computeIfAbsent(edge[1], val -> new ArrayList<>()).add(edge[0]);
        }

        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 1) {
                queue.offer(i);
            }
        }

        int unused = n;
        while (unused > 2) {
            int size = queue.size();
            unused -= size;

            for (int i = 0; i < size; i++) {
                int curr = queue.poll();

                if (adj.containsKey(curr)) {
                    List<Integer> neighbors = adj.get(curr);
                    for (int neighbor : neighbors) {
                        inDegree[neighbor]--;
                        if (inDegree[neighbor] == 1) {
                            queue.offer(neighbor);
                        }
                    }
                }
            }
        }

        while (!queue.isEmpty()) {
            roots.add(queue.poll());
        }
        return roots;
    }
}
