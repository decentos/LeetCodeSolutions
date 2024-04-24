package graph;

import java.util.*;

public class M787CheapestFlights {

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] prices = new int[n];
        Arrays.fill(prices, Integer.MAX_VALUE);
        prices[src] = 0;

        Map<Integer, List<int[]>> adj = new HashMap<>();
        for (int[] flight : flights) {
            adj.computeIfAbsent(flight[0], val -> new ArrayList<>()).add(new int[]{flight[1], flight[2]});
        }

        Deque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{src, 0});

        while (!queue.isEmpty() && k >= 0) {
            k--;
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                int source = curr[0];
                int currPrice = curr[1];

                if (adj.containsKey(source)) {
                    List<int[]> dists = adj.get(source);

                    for (int[] dist : dists) {
                        int distName = dist[0];
                        int distPrice = dist[1] + currPrice;

                        if (distPrice < prices[distName]) {
                            prices[distName] = distPrice;
                            queue.offer(new int[]{distName, distPrice});
                        }
                    }
                }
            }
        }
        return prices[dst] == Integer.MAX_VALUE ? -1 : prices[dst];
    }
}
