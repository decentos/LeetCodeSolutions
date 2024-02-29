package graph;

import java.util.*;

public class H2709GreatestCommonDivisor {

    public boolean canTraverseAllPairs(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return true;
        }

        Graph graph = new Graph(n);
        HashMap<Integer, Integer> seen = new HashMap<>();

        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) {
                return false;
            }
            List<Integer> primeFactors = getPrimeFactors(nums[i]);
            for (int prime : primeFactors) {
                if (seen.containsKey(prime)) {
                    graph.addEdge(i, seen.get(prime));
                } else {
                    seen.put(prime, i);
                }
            }
        }
        return graph.isConnected();
    }

    private List<Integer> getPrimeFactors(int x) {
        List<Integer> primeFactors = new ArrayList<>();
        for (int i = 2; i * i <= x; i++) {
            if (x % i == 0) {
                primeFactors.add(i);
                while (x % i == 0) {
                    x /= i;
                }
            }
        }
        if (x != 1) {
            primeFactors.add(x);
        }
        return primeFactors;
    }

    private static class Graph {
        private final int n;
        private final Map<Integer, List<Integer>> edges;
        private final boolean[] visited;

        private void traverse() {
            Queue<Integer> queue = new LinkedList<>();
            queue.offer(0);

            while (!queue.isEmpty()) {
                int curr = queue.poll();

                if (edges.containsKey(curr)) {
                    for (int y : edges.get(curr)) {
                        if (!visited[y]) {
                            queue.add(y);
                            visited[y] = true;
                        }
                    }
                }
            }
        }

        public Graph(int n) {
            this.n = n;
            edges = new HashMap<>();
            visited = new boolean[n];
        }

        public void addEdge(int x, int y) {
            edges.computeIfAbsent(x, value -> new ArrayList<>()).add(y);
            edges.computeIfAbsent(y, value -> new ArrayList<>()).add(x);
        }

        public boolean isConnected() {
            Arrays.fill(visited, false);
            traverse();
            int count = 0;
            for (boolean v : visited) {
                count += v ? 1 : 0;
            }
            return count == n;
        }
    }
}
