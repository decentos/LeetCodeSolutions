package graph.unionfind;

import java.util.*;

public class H2493MaxNumberGroups {

    public int magnificentSets(int n, int[][] edges) {
        int totalGroups = 0;
        UnionFind uf = new UnionFind(n + 1);
        Map<Integer, List<Integer>> adj = new HashMap<>();
        Map<Integer, List<Integer>> groups = new HashMap<>();

        for (int[] edge : edges) {
            adj.computeIfAbsent(edge[0], val -> new ArrayList<>()).add(edge[1]);
            adj.computeIfAbsent(edge[1], val -> new ArrayList<>()).add(edge[0]);
            uf.union(edge[0], edge[1]);
        }

        for (int i = 1; i <= n; i++) {
            int parent = uf.find(i);
            groups.computeIfAbsent(parent, val -> new ArrayList<>()).add(i);
        }

        for (List<Integer> group : groups.values()) {
            if (!isBipartite(n, group.getFirst(), adj)) {
                return -1;
            }
            totalGroups += calculateMaxLength(n, group, adj);
        }
        return totalGroups;
    }

    private boolean isBipartite(int n, int root, Map<Integer, List<Integer>> adj) {
        Deque<Integer> queue = new ArrayDeque<>();
        int[] state = new int[n + 1];
        queue.offer(root);
        state[root] = 1;

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            if (adj.containsKey(curr)) {
                List<Integer> neighbors = adj.get(curr);
                for (int neighbor : neighbors) {
                    if (state[neighbor] == 0) {
                        state[neighbor] = state[curr] == 1 ? 2 : 1;
                        queue.offer(neighbor);
                    } else if (state[neighbor] == state[curr]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private int calculateMaxLength(int n, List<Integer> group, Map<Integer, List<Integer>> adj) {
        Deque<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[n + 1];
        int maxLength = 0;

        for (int root : group) {
            int currLength = 0;
            queue.offer(root);
            visited[root] = true;

            while (!queue.isEmpty()) {
                currLength++;
                int size = queue.size();

                for (int i = 0; i < size; i++) {
                    int curr = queue.poll();
                    if (adj.containsKey(curr)) {
                        List<Integer> neighbors = adj.get(curr);
                        for (int neighbor : neighbors) {
                            if (!visited[neighbor]) {
                                visited[neighbor] = true;
                                queue.offer(neighbor);
                            }
                        }
                    }
                }
            }

            maxLength = Math.max(maxLength, currLength);
            Arrays.fill(visited, false);
        }
        return maxLength;
    }

    private static class UnionFind {
        private final int[] root;
        private final int[] rank;

        public UnionFind(int size) {
            root = new int[size];
            rank = new int[size];

            for (int i = 0; i < size; i++) {
                root[i] = i;
                rank[i] = 1;
            }
        }

        public int find(int node) {
            if (root[node] == node) {
                return node;
            }
            return root[node] = find(root[node]);
        }

        public void union(int nodeX, int nodeY) {
            int rootX = find(nodeX);
            int rootY = find(nodeY);

            if (rootX != rootY) {
                if (rank[rootX] < rank[rootY]) {
                    root[rootY] = rootX;
                } else if (rank[rootX] > rank[rootY]) {
                    root[rootX] = rootY;
                } else {
                    root[rootY] = rootX;
                    rank[rootX]++;
                }
            }
        }
    }
}
