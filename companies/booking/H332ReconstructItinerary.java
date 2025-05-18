package booking;

import java.util.*;

public class H332ReconstructItinerary {

    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, Queue<String>> graph = new HashMap<>();
        for (List<String> ticket : tickets) {
            String from = ticket.get(0);
            String to = ticket.get(1);
            graph.computeIfAbsent(from, val -> new PriorityQueue<>()).offer(to);
        }

        LinkedList<String> path = new LinkedList<>();
        dfs(graph, path, "JFK");
        return path;
    }

    private void dfs(Map<String, Queue<String>> graph, LinkedList<String> path, String source) {
        if (graph.containsKey(source)) {
            Queue<String> dist = graph.get(source);
            while (!dist.isEmpty()) {
                dfs(graph, path, dist.poll());
            }
        }
        path.addFirst(source);
    }
}
