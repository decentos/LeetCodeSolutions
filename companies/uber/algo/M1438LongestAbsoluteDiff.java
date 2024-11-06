package uber.algo;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.TreeMap;

public class M1438LongestAbsoluteDiff {

    public int longestSubarray(int[] nums, int limit) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int left = 0, max = 0;

        for (int right = 0; right < nums.length; right++) {
            map.merge(nums[right], 1, Integer::sum);
            while (map.lastKey() - map.firstKey() > limit) {
                int removedCount = map.merge(nums[left], -1, Integer::sum);
                if (removedCount == 0) {
                    map.remove(nums[left]);
                }
                left++;
            }
            max = Math.max(max, right - left + 1);
        }
        return max;
    }

// ===============================================================================

    public int longestSubarray2(int[] nums, int limit) {
        Deque<Integer> minQueue = new ArrayDeque<>();
        Deque<Integer> maxQueue = new ArrayDeque<>();
        int left = 0, max = 0;

        for (int right = 0; right < nums.length; right++) {
            while (!minQueue.isEmpty() && minQueue.peekLast() > nums[right]) {
                minQueue.pollLast();
            }
            minQueue.offerLast(nums[right]);

            while (!maxQueue.isEmpty() && maxQueue.peekLast() < nums[right]) {
                maxQueue.pollLast();
            }
            maxQueue.offerLast(nums[right]);

            while (maxQueue.peek() - minQueue.peek() > limit) {
                if (maxQueue.peek() == nums[left]) {
                    maxQueue.poll();
                }
                if (minQueue.peek() == nums[left]) {
                    minQueue.poll();
                }
                left++;
            }
            max = Math.max(max, right - left + 1);
        }
        return max;
    }
}
