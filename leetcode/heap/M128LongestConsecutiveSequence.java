package heap;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class M128LongestConsecutiveSequence {

    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;

        Queue<Integer> heap = new PriorityQueue<>();
        for (int num : nums) heap.offer(num);

        int max = 0;
        while (!heap.isEmpty()) {
            int curr = heap.poll();
            int currMax = 1;
            while (!heap.isEmpty() && (curr + 1 == heap.peek() || curr == heap.peek())) {
                int next = heap.poll();
                if (curr == next) continue;
                curr = next;
                currMax++;
            }

            if (heap.isEmpty() || curr + 1 != heap.peek()) {
                max = Math.max(max, currMax);
            }
        }
        return max;
    }

    public int longestConsecutive2(int[] nums) {
        if (nums.length == 0) return 0;

        Set<Integer> set = new HashSet<>();
        for (int num : nums) set.add(num);

        int max = 0;
        for (int num : nums) {
            if (!set.contains(num - 1)) {
                int currMax = 1;
                int next = num + 1;
                while (set.contains(next)) {
                    currMax++;
                    next++;
                }
                max = Math.max(max, currMax);
            }
        }
        return max;
    }
}
