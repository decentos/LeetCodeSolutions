package w342;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class M2653SlidingSubarrayBeauty {

    public int[] getSubarrayBeauty(int[] nums, int k, int x) {
        int n = nums.length;
        int[] freq = new int[50];
        int[] ans = new int[n - k + 1];
        
        for (int i = 0; i < n; i++) {
            if (nums[i] < 0) freq[nums[i] + 50]++;
            if (i - k >= 0 && nums[i - k] < 0) freq[nums[i - k] + 50]--;
            if (i - k + 1 < 0) continue;

            int count = 0;
            for (int j = 0; j < 50; j++) {
                count += freq[j];
                if (count >= x) {
                    ans[i - k + 1] = j - 50;
                    break;
                }
            }
        }
        return ans;
    }

    public int[] getSubarrayBeauty2(int[] nums, int k, int x) {
        int n = nums.length;
        int[] ans = new int[n - k + 1];

        for (int i = 0; i <= n - k; i++) {
            ans[i] = findSmallest(nums, i, i + k, x);
        }
        return ans;
    }

    private int findSmallest(int[] nums, int start, int end, int x) {
        Queue<Integer> heap = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = start; i < end; i++) {
            int curr = nums[i];
            if (heap.size() < x) {
                heap.offer(curr);
            } else if (heap.peek() > curr) {
                heap.poll();
                heap.offer(curr);
            }
        }
        return Math.min(heap.peek(), 0);
    }
}
