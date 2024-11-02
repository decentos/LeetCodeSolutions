package uber;

import java.util.ArrayDeque;
import java.util.Deque;

public class M785IsGraphBipartite {

    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] states = new int[n];
        Deque<Integer> queue = new ArrayDeque<>();

        for (int node = 0; node < n; node++) {
            if (states[node] != 0) {
                continue;
            }

            queue.offer(node);
            states[node] = 1;

            while (!queue.isEmpty()) {
                int curr = queue.poll();
                int[] neighbors = graph[curr];
                for (int neighbor : neighbors) {
                    if (states[neighbor] == 0) {
                        int nextState = states[curr] == 1 ? 2 : 1;
                        states[neighbor] = nextState;
                        queue.offer(neighbor);
                    } else if (states[neighbor] == states[curr]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
