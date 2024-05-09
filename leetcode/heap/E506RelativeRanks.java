package heap;

import java.util.PriorityQueue;
import java.util.Queue;

public class E506RelativeRanks {

    public String[] findRelativeRanks(int[] score) {
        int n = score.length;
        String[] ranks = new String[n];
        Queue<int[]> heap = new PriorityQueue<>((a, b) -> b[1] - a[1]);

        for (int i = 0; i < n; i++) {
            heap.offer(new int[]{i, score[i]});
        }

        int rank = 1;
        while (!heap.isEmpty()) {
            int index = heap.poll()[0];

            if (rank == 1) {
                ranks[index] = "Gold Medal";
            } else if (rank == 2) {
                ranks[index] = "Silver Medal";
            } else if (rank == 3) {
                ranks[index] = "Bronze Medal";
            } else {
                ranks[index] = String.valueOf(rank);
            }
            rank++;
        }
        return ranks;
    }
}
