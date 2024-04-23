package graph.dijkstra;

import java.util.*;

public class M743NetworkDelayTime {

    public int networkDelayTime(int[][] times, int n, int k) {
        int[] delays = new int[n + 1];
        Arrays.fill(delays, Integer.MAX_VALUE);
        delays[0] = 0;
        delays[k] = 0;

        Queue<Edge> queue = new PriorityQueue<>();
        queue.offer(new Edge(k, 0));

        Map<Integer, List<Edge>> adj = new HashMap<>();
        for (int[] time : times) {
            adj.computeIfAbsent(time[0], val -> new ArrayList<>()).add(new Edge(time[1], time[2]));
        }

        while (!queue.isEmpty()) {
            Edge curr = queue.poll();
            if (adj.containsKey(curr.node)) {
                List<Edge> neighbors = adj.get(curr.node);
                for (Edge neighbor : neighbors) {
                    if (delays[neighbor.node] > curr.time + neighbor.time) {
                        delays[neighbor.node] = curr.time + neighbor.time;
                        queue.offer(new Edge(neighbor.node, neighbor.time + curr.time));
                    }
                }
            }
        }

        int maxDelay = 0;
        for (int delay : delays) {
            if (delay == Integer.MAX_VALUE) {
                return -1;
            }
            maxDelay = Math.max(maxDelay, delay);
        }
        return maxDelay;
    }

    private static class Edge implements Comparable<Edge> {
        int node;
        int time;

        public Edge(int node, int time) {
            this.node = node;
            this.time = time;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.time, o.time);
        }
    }
}
