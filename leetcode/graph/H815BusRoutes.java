package graph;

import java.util.*;

public class H815BusRoutes {

    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target) {
            return 0;
        }

        int n = routes.length;
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int route = 0; route < n; route++) {
            for (int stop : routes[route]) {
                adj.computeIfAbsent(stop, val -> new ArrayList<>()).add(route);
            }
        }

        if (!adj.containsKey(source)) {
            return -1;
        }

        int buses = 0;
        Deque<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[n];

        for (int route : adj.get(source)) {
            queue.offer(route);
            visited[route] = true;
        }

        while (!queue.isEmpty()) {
            buses++;
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int route = queue.poll();

                for (int stop : routes[route]) {
                    if (stop == target) {
                        return buses;
                    }

                    List<Integer> connections = adj.get(stop);
                    for (int connection : connections) {
                        if (!visited[connection]) {
                            visited[connection] = true;
                            queue.offer(connection);
                        }
                    }
                }
            }
        }
        return -1;
    }
}
