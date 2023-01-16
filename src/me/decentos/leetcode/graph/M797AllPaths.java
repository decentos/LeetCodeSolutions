package me.decentos.leetcode.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class M797AllPaths {
    private static final List<List<Integer>> allPaths = new ArrayList<>();

    public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        Map<Integer, List<Integer>> edges = new HashMap<>();
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                edges.computeIfAbsent(i, val -> new ArrayList<>()).add(graph[i][j]);
            }
        }
        helper(edges, new ArrayList<>(), 0, graph.length - 1);
        return allPaths;
    }

    private static void helper(Map<Integer, List<Integer>> edges, List<Integer> curPaths, int source, int target) {
        curPaths.add(source);
        if (source == target) {
            allPaths.add(curPaths);
            return;
        }

        List<Integer> nodes = edges.get(source);
        if (nodes == null) return;
        for (int node : nodes) {
            helper(edges, new ArrayList<>(curPaths), node, target);
        }
    }
}
