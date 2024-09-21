package graph;

import java.util.*;

public class M1466ReorderRoutesToCityZero {

    public int minReorder(int n, int[][] connections) {
        int count = 0;
        boolean[] seen = new boolean[n];
        seen[0] = true;
        Deque<Integer> routes = new ArrayDeque<>();
        routes.offer(0);
        Map<Integer, List<Route>> graph = new HashMap<>();

        for (int[] connection : connections) {
            int source = connection[0];
            int dist = connection[1];
            graph.computeIfAbsent(source, val -> new ArrayList<>()).add(new Route(source, dist, 1));
            graph.computeIfAbsent(dist, val -> new ArrayList<>()).add(new Route(dist, source, 0));
        }

        while (!routes.isEmpty()) {
            int source = routes.poll();
            if (graph.containsKey(source)) {
                List<Route> neighbors = graph.get(source);
                for (Route neighbor : neighbors) {
                    if (!seen[neighbor.dist]) {
                        count += neighbor.sign;
                        seen[neighbor.dist] = true;
                        routes.offer(neighbor.dist);
                    }
                }
            }
        }
        return count;
    }

    private record Route(int source, int dist, int sign) {}
}
