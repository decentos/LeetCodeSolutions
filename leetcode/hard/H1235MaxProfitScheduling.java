package hard;

import java.util.*;

public class H1235MaxProfitScheduling {

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        List<Job> jobs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            jobs.add(new Job(startTime[i], endTime[i], profit[i]));
        }
        Collections.sort(jobs, Comparator.comparingInt(a -> a.startTime));

        Queue<Job> heap = new PriorityQueue<>(Comparator.comparingInt(a -> a.endTime));
        int max = 0;
        for (Job curr : jobs) {
            while (!heap.isEmpty() && curr.startTime >= heap.peek().endTime) {
                max = Math.max(max, heap.poll().profit);
            }
            heap.offer(new Job(curr.startTime, curr.endTime, curr.profit + max));
        }

        while (!heap.isEmpty()) {
            max = Math.max(max, heap.poll().profit);
        }
        return max;
    }

    private static class Job {
        int startTime;
        int endTime;
        int profit;

        public Job(int startTime, int endTime, int profit) {
            this.startTime = startTime;
            this.endTime = endTime;
            this.profit = profit;
        }
    }
}
