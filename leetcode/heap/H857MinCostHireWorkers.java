package heap;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class H857MinCostHireWorkers {

    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        int n = wage.length;
        int totalQuality = 0;
        double minCost = Double.MAX_VALUE;
        Queue<Integer> qualities = new PriorityQueue<>(Comparator.reverseOrder());
        Queue<Ratio> ratio = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            ratio.offer(new Ratio((double) wage[i] / quality[i], quality[i]));
        }

        while (!ratio.isEmpty()) {
            Ratio curr = ratio.poll();

            totalQuality += curr.quality;
            qualities.offer(curr.quality);

            if (qualities.size() > k) {
                totalQuality -= qualities.poll();
            }

            if (qualities.size() == k) {
                minCost = Math.min(minCost, totalQuality * curr.ratio);
            }
        }
        return minCost;
    }

    private static class Ratio implements Comparable<Ratio> {
        double ratio;
        int quality;

        public Ratio(double ratio, int quality) {
            this.ratio = ratio;
            this.quality = quality;
        }

        @Override
        public int compareTo(Ratio o) {
            return Double.compare(this.ratio, o.ratio);
        }
    }
}
