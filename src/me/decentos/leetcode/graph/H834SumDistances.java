package me.decentos.leetcode.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class H834SumDistances {
    private static int sum = 0;

    public static int[] sumOfDistancesInTree(int n, int[][] edges) {
        if (n == 1) return new int[]{0};
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            int a = edge[0], b = edge[1];
            graph.computeIfAbsent(a, val -> new ArrayList<>()).add(b);
            graph.computeIfAbsent(b, val -> new ArrayList<>()).add(a);
        }
        int[] sums = new int[n];

        for (int i = 0; i < n; i++) {
            boolean[] seen = new boolean[n];
            sum = 0;
            dfs(graph, seen, i, 1);
            sums[i] = sum;
        }
        return sums;
    }

    private static void dfs(Map<Integer, List<Integer>> graph, boolean[] seen, int current, int level) {
        seen[current] = true;
        List<Integer> nodes = graph.get(current);
        if (nodes != null) {
            for (int node : nodes) {
                if (!seen[node]) {
                    sum += level;
                    dfs(graph, seen, node, level + 1);
                }
            }
        }
    }

    private static int bfs(Map<Integer, List<Integer>> graph, int n, int sourceNode) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(sourceNode);

        boolean[] visited = new boolean[n];
        visited[sourceNode] = true;

        int distance = 0, level = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            level += 1;

            for (int i = 0; i < size; i++) {
                int currNode = queue.poll();

                for (int nextNode : graph.get(currNode)) {
                    if (!visited[nextNode]) {
                        visited[nextNode] = true;
                        distance += level;
                        queue.offer(nextNode);
                    }
                }
            }
        }
        return distance;
    }

    private static Map<Integer, List<Integer>> graph;
    private static int[] sums, count;
    private static int size;

    public static int[] sumOfDistancesInTree2(int n, int[][] edges) {
        size = n;
        sums = new int[n];
        count = new int[n];
        Arrays.fill(count, 1);
        graph = new HashMap<>();
        for (int[] edge : edges) {
            int a = edge[0], b = edge[1];
            graph.computeIfAbsent(a, val -> new ArrayList<>()).add(b);
            graph.computeIfAbsent(b, val -> new ArrayList<>()).add(a);
        }
        postOrder(0, -1);
        preOrder(0, -1);
        return sums;
    }

    private static void postOrder(int node, int parent) {
        if (!graph.containsKey(node)) return;
        for (int child : graph.get(node))
            if (child != parent) {
                postOrder(child, node);
                count[node] += count[child];
                sums[node] += sums[child] + count[child];
            }
    }

    private static void preOrder(int node, int parent) {
        if (!graph.containsKey(node)) return;
        for (int child : graph.get(node))
            if (child != parent) {
                sums[child] = sums[node] - count[child] + size - count[child];
                preOrder(child, node);
            }
    }
}
