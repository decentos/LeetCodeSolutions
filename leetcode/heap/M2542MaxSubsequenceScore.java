package heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class M2542MaxSubsequenceScore {

    public long maxScore(int[] nums1, int[] nums2, int k) {
        long sum = 0, score = 0;

        int n = nums1.length;
        int[][] pairs = new int[n][2];
        for (int i = 0; i < n; i++) {
            pairs[i] = new int[]{nums1[i], nums2[i]};
        }
        Arrays.sort(pairs, Comparator.comparingInt(a -> -a[1]));

        Queue<Integer> heap = new PriorityQueue<>();
        for (int i = 0; i < k; i++) {
            sum += pairs[i][0];
            heap.offer(pairs[i][0]);
        }
        score = sum * pairs[k - 1][1];

        for (int i = k; i < n; i++) {
            sum += pairs[i][0] - heap.poll();
            heap.offer(pairs[i][0]);
            score = Math.max(score, sum * pairs[i][1]);
        }
        return score;
    }
}
