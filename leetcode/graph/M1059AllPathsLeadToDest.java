package graph;

import java.util.*;

public class M1059AllPathsLeadToDest {

    public boolean leadsToDestination(int n, int[][] edges, int source, int destination) {
        Map<Integer, List<Integer>> adj = new HashMap<>();

        for (int[] edge : edges) {
            if (edge[0] == destination) {
                return false;
            }
            adj.computeIfAbsent(edge[0], val -> new ArrayList<>()).add(edge[1]);
        }

        return dfs(adj, new HashSet<>(), new boolean[n], source, destination);
    }

    private boolean dfs(Map<Integer, List<Integer>> adj, Set<Integer> memo, boolean[] visited, int source, int destination) {
        if (memo.contains(source) || source == destination) {
            return true;
        } else if (visited[source] || !adj.containsKey(source)) {
            return false;
        }

        visited[source] = true;
        List<Integer> neighbors = adj.get(source);

        for (int neighbor : neighbors) {
            if (!dfs(adj, memo, visited, neighbor, destination)) {
                return false;
            }
        }

        visited[source] = false;
        memo.add(source);
        return true;
    }
}
