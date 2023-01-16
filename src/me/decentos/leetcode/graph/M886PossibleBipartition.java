package me.decentos.leetcode.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class M886PossibleBipartition {

    public boolean possibleBipartition(int n, int[][] dislikes) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge : dislikes) {
            int a = edge[0], b = edge[1];
            graph.computeIfAbsent(a, value -> new ArrayList<>()).add(b);
            graph.computeIfAbsent(b, value -> new ArrayList<>()).add(a);
        }

        int[] color = new int[n + 1];
        Arrays.fill(color, -1); // 0 stands for red and 1 stands for blue.

        for (int i = 1; i <= n; i++) {
            if (color[i] == -1) {
                // For each pending component, run BFS or DFS.
                if (!bfs(i, graph, color))
//                if (!dfs(i, 0, graph, color))
                    // Return false, if there is conflict in the component.
                    return false;
            }
        }
        return true;
    }

    private boolean bfs(int source, Map<Integer, List<Integer>> graph, int[] color) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(source);
        color[source] = 0; // Start with marking source as `RED`.

        while (!q.isEmpty()) {
            int node = q.poll();
            if (!graph.containsKey(node))
                continue;
            for (int neighbor : graph.get(node)) {
                if (color[neighbor] == color[node])
                    return false;
                if (color[neighbor] == -1) {
                    color[neighbor] = 1 - color[node];
                    q.add(neighbor);
                }
            }
        }
        return true;
    }

    private boolean dfs(int node, int nodeColor, Map<Integer, List<Integer>> graph, int[] color) {
        color[node] = nodeColor;
        if (!graph.containsKey(node))
            return true;
        for (int neighbor : graph.get(node)) {
            if (color[neighbor] == color[node])
                return false;
            if (color[neighbor] == -1) {
                if (!dfs(neighbor, 1 - nodeColor, graph, color))
                    return false;
            }
        }
        return true;
    }
}
