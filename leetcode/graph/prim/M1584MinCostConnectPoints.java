package graph.prim;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class M1584MinCostConnectPoints {

    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        int cost = 0, count = n;
        boolean[] visited = new boolean[n];
        Queue<int[]> heap = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        heap.offer(new int[]{0, 0});

        while (count != 0) {
            int[] curr = heap.poll();
            int currNode = curr[0];
            int currWeight = curr[1];
            if (!visited[currNode]) {
                visited[currNode] = true;
                cost += currWeight;
                count--;

                for (int i = 0; i < n; i++) {
                    if (!visited[i]) {
                        int weight = Math.abs(points[currNode][0] - points[i][0]) + Math.abs(points[currNode][1] - points[i][1]);
                        heap.offer(new int[]{i, weight});
                    }
                }
            }
        }
        return cost;
    }
}
