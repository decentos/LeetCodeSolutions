package uber.algo;

import java.util.*;

public class H815BusRoutes {

    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target) {
            return 0;
        }

        int n = routes.length;
        boolean[] visited = new boolean[n];
        Map<Integer, List<Integer>> stopToRoutes = new HashMap<>();

        for (int route = 0; route < n; route++) {
            for (int stop : routes[route]) {
                stopToRoutes.computeIfAbsent(stop, val -> new ArrayList<>()).add(route);
            }
        }

        if (!stopToRoutes.containsKey(source) || !stopToRoutes.containsKey(target)) {
            return -1;
        }

        Deque<Integer> queue = new ArrayDeque<>();
        int busCount = 1;
        for (int route : stopToRoutes.get(source)) {
            queue.offer(route);
            visited[route] = true;
        }

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int route = queue.poll();

                for (int stop : routes[route]) {
                    if (stop == target) {
                        return busCount;
                    }

                    List<Integer> neighbors = stopToRoutes.get(stop);
                    for (int neighbor : neighbors) {
                        if (!visited[neighbor]) {
                            visited[neighbor] = true;
                            queue.offer(neighbor);
                        }
                    }
                }
            }
            busCount++;
        }
        return -1;
    }
}
