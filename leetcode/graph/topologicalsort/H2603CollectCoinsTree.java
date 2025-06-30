package graph.topologicalsort;

import java.util.*;

public class H2603CollectCoinsTree {

    public int collectTheCoins(int[] coins, int[][] edges) {
        int n = coins.length;
        int totalEdges = edges.length * 2, deletedEdges = 0;
        int[] inDegree = new int[n];
        Map<Integer, List<Integer>> adj = new HashMap<>();
        Deque<Integer> deletedQueue = new ArrayDeque<>();

        for (int[] edge : edges) {
            int from = edge[0], to = edge[1];
            inDegree[from]++;
            inDegree[to]++;
            adj.computeIfAbsent(from, val -> new ArrayList<>()).add(to);
            adj.computeIfAbsent(to, val -> new ArrayList<>()).add(from);
        }

        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 1 && coins[i] == 0) {
                deletedQueue.offer(i);
            }
        }

        while (!deletedQueue.isEmpty()) {
            int curr = deletedQueue.poll();

            if (inDegree[curr] == 0) {
                continue;
            }

            if (adj.containsKey(curr)) {
                List<Integer> neighbors = adj.get(curr);

                for (int neighbor : neighbors) {
                    if (inDegree[neighbor] == 0) {
                        continue;
                    }

                    inDegree[curr]--;
                    inDegree[neighbor]--;
                    deletedEdges += 2;

                    if (inDegree[neighbor] == 1 && coins[neighbor] == 0) {
                        deletedQueue.offer(neighbor);
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 1) {
                deletedQueue.offer(i);
            }
        }

        for (int step = 0; step < 2; step++) {
            int size = deletedQueue.size();

            for (int i = 0; i < size; i++) {
                int curr = deletedQueue.poll();

                if (inDegree[curr] == 0) {
                    continue;
                }

                if (adj.containsKey(curr)) {
                    List<Integer> neighbors = adj.get(curr);

                    for (int neighbor : neighbors) {
                        if (inDegree[neighbor] == 0) {
                            continue;
                        }

                        inDegree[curr]--;
                        inDegree[neighbor]--;
                        deletedEdges += 2;

                        if (inDegree[neighbor] == 1) {
                            deletedQueue.offer(neighbor);
                        }
                    }
                }
            }
        }
        return totalEdges - deletedEdges;
    }
}
