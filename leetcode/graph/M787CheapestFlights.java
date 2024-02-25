package graph;

import java.util.*;

public class M787CheapestFlights {

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, List<int[]>> adj = new HashMap<>();
        for (int[] flight : flights) {
            adj.computeIfAbsent(flight[0], val -> new ArrayList<>()).add(new int[]{flight[1], flight[2]});
        }

        int[] prices = new int[n];
        Arrays.fill(prices, Integer.MAX_VALUE);

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{src, 0});

        while (!queue.isEmpty() && k >= 0) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                int currDist = curr[0];
                int currPrice = curr[1];

                if (adj.containsKey(currDist)) {
                    for (int[] next : adj.get(currDist)) {
                        int nextDist = next[0];
                        int nextPrice = next[1];

                        if (currPrice + nextPrice < prices[nextDist]) {
                            prices[nextDist] = currPrice + nextPrice;
                            queue.offer(new int[]{nextDist, prices[nextDist]});
                        }
                    }
                }
            }
            k--;
        }
        return prices[dst] == Integer.MAX_VALUE ? -1 : prices[dst];
    }
}
