package uber.algo;

import java.util.*;

public class M2101DetonateMaxBombs {

    public int maximumDetonation(int[][] bombs) {
        int n = bombs.length;
        int maxCount = 0;
        Map<Integer, List<Integer>> adj = new HashMap<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }

                if (inRange(bombs[i], bombs[j])) {
                    adj.computeIfAbsent(i, val -> new ArrayList<>()).add(j);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            int currCount = 0;
            boolean[] visited = new boolean[n];
            Deque<Integer> queue = new ArrayDeque<>();
            queue.offer(i);
            visited[i] = true;

            while (!queue.isEmpty()) {
                int curr = queue.poll();
                currCount++;

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
            maxCount = Math.max(maxCount, currCount);
        }
        return maxCount;
    }

    private boolean inRange(int[] a, int[] b) {
        long dx = a[0] - b[0], dy = a[1] - b[1], r = a[2];
        return dx * dx + dy * dy <= r * r;
    }
}
