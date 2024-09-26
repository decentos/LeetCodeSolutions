package heap;

import java.util.PriorityQueue;
import java.util.Queue;

public class M2462TotalCostHireWorkers {

    public long totalCost(int[] costs, int k, int candidates) {
        int n = costs.length;
        Queue<Integer> left = new PriorityQueue<>();
        Queue<Integer> right = new PriorityQueue<>();
        int nextLeft = 0, nextRight = n - 1;
        long totalCost = 0;

        for (int i = 0; i < candidates; i++) {
            left.offer(costs[i]);
            nextLeft++;
        }

        for (int i = Math.max(candidates, n - candidates); i < n; i++) {
            right.offer(costs[i]);
            nextRight--;
        }

        for (int i = 0; i < k; i++) {
            if (right.isEmpty() || !left.isEmpty() && left.peek() <= right.peek()) {
                totalCost += left.poll();
                if (nextLeft <= nextRight) {
                    left.offer(costs[nextLeft++]);
                }
            } else {
                totalCost += right.poll();
                if (nextLeft <= nextRight) {
                    right.offer(costs[nextRight--]);
                }
            }
        }
        return totalCost;
    }
}
