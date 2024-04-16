package graph;

import java.util.*;

public class H332ReconstructItinerary {

    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, Queue<String>> adj = new HashMap<>();
        for (List<String> ticket : tickets) {
            String from = ticket.get(0);
            String to = ticket.get(1);
            adj.computeIfAbsent(from, val -> new PriorityQueue<>()).offer(to);
        }

        LinkedList<String> path = new LinkedList<>();
        dfs(adj, path, "JFK");
        return path;
    }

    private void dfs(Map<String, Queue<String>> adj, LinkedList<String> path, String source) {
        if (adj.containsKey(source)) {
            Queue<String> dist = adj.get(source);
            while (!dist.isEmpty()) {
                dfs(adj, path, dist.poll());
            }
        }
        path.addFirst(source);
    }
}
