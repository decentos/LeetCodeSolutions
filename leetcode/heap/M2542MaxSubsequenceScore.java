package heap;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class M2542MaxSubsequenceScore {

    public long maxScore(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        int[][] pairs = new int[n][2];
        for (int i = 0; i < n; i++) {
            pairs[i] = new int[]{nums1[i], nums2[i]};
        }
        Arrays.sort(pairs, (a, b) -> b[1] - a[1]);

        Queue<Integer> heap = new PriorityQueue<>();
        long max = 0, sum = 0;

        for (int[] pair : pairs) {
            if (heap.size() < k) {
                sum += pair[0];
                heap.offer(pair[0]);
            } else if (heap.peek() < pair[0]) {
                sum = sum - heap.poll() + pair[0];
                heap.offer(pair[0]);
            }

            if (heap.size() == k) max = Math.max(max, sum * pair[1]);
        }
        return max;
    }
}
