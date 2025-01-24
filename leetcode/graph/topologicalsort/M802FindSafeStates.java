package graph.topologicalsort;

import java.util.*;

public class M802FindSafeStates {

    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        boolean[] terminal = new boolean[n];
        int[] outDegree = new int[n];
        Map<Integer, ArrayList<Integer>> inDegree = new HashMap<>();
        Deque<Integer> queue = new ArrayDeque<>();

        for (int curr = 0; curr < n; curr++) {
            outDegree[curr] = graph[curr].length;
            for (int node : graph[curr]) {
                inDegree.computeIfAbsent(node, val -> new ArrayList<>()).add(curr);
            }
        }

        for (int i = 0; i < n; i++) {
            if (outDegree[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            terminal[curr] = true;

            if (inDegree.containsKey(curr)) {
                List<Integer> neighbors = inDegree.get(curr);

                for (int neighbor : neighbors) {
                    outDegree[neighbor]--;

                    if (outDegree[neighbor] == 0) {
                        queue.offer(neighbor);
                    }
                }
            }
        }

        List<Integer> safe = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (terminal[i]) {
                safe.add(i);
            }
        }
        return safe;
    }
}
