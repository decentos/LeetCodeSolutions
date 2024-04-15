package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class M1059AllPathsLeadToDest {

    public boolean leadsToDestination(int n, int[][] edges, int source, int destination) {
        Map<Integer, List<Integer>> adj = new HashMap<>();

        for (int[] edge : edges) {
            if (edge[0] == destination) {
                return false;
            }
            adj.computeIfAbsent(edge[0], val -> new ArrayList<>()).add(edge[1]);
        }
        return dfs(adj, new HashMap<>(), new boolean[n], source, destination);
    }

    private boolean dfs(Map<Integer, List<Integer>> adj, Map<Integer, Boolean> memo, boolean[] visited, int source, int destination) {
        if (memo.containsKey(source)) {
            return memo.get(source);
        } else if (source == destination) {
            return true;
        } else if (visited[source] || !adj.containsKey(source)) {
            return false;
        }

        visited[source] = true;
        List<Integer> neighbors = adj.get(source);

        for (int neighbor : neighbors) {
            if (!dfs(adj, memo, visited, neighbor, destination)) {
                memo.put(source, false);
                return false;
            }
        }
        visited[source] = false;
        memo.put(source, true);
        return true;
    }
}
