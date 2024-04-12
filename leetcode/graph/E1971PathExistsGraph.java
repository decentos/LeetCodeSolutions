package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class E1971PathExistsGraph {

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        boolean[] visited = new boolean[n];

        for (int[] edge : edges) {
            adj.computeIfAbsent(edge[0], val -> new ArrayList<>()).add(edge[1]);
            adj.computeIfAbsent(edge[1], val -> new ArrayList<>()).add(edge[0]);
        }

        return dfs(adj, visited, source, destination);
    }

    private boolean dfs(Map<Integer, List<Integer>> adj, boolean[] visited, int source, int destination) {
        if (source == destination) {
            return true;
        } else if (visited[source]) {
            return false;
        }

        visited[source] = true;
        List<Integer> neighbors = adj.get(source);
        for (int neighbor : neighbors) {
            if (dfs(adj, visited, neighbor, destination)) {
                return true;
            }
        }
        return false;
    }
}
