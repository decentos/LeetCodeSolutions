package graph.bellmanford;

public class M787CheapestFlights {

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] prev = new int[n];
        int[] curr = new int[n];

        for (int i = 0; i < n; i++) {
            prev[i] = Integer.MAX_VALUE;
            curr[i] = Integer.MAX_VALUE;
        }
        prev[src] = 0;
        curr[src] = 0;

        for (int i = 0; i <= k; i++) {
            for (int[] flight : flights) {
                int source = flight[0];
                int dist = flight[1];
                int price = flight[2];

                if (prev[source] < Integer.MAX_VALUE) {
                    curr[dist] = Math.min(curr[dist], prev[source] + price);
                }
            }
            prev = curr.clone();
        }
        return curr[dst] == Integer.MAX_VALUE ? -1 : curr[dst];
    }
}
