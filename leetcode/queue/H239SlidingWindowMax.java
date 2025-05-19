package queue;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class H239SlidingWindowMax {

    public int[] maxSlidingWindow(int[] nums, int k) {
        List<Integer> max = new ArrayList<>();
        Deque<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < k; i++) {
            while (!queue.isEmpty() && nums[i] >= nums[queue.peekLast()]) {
                queue.pollLast();
            }
            queue.offerLast(i);
        }
        max.add(nums[queue.peek()]);

        for (int i = k; i < nums.length; i++) {
            if (queue.peek() == i - k) {
                queue.poll();
            }
            while (!queue.isEmpty() && (nums[i] >= nums[queue.peekLast()])) {
                queue.pollLast();
            }
            queue.offerLast(i);
            max.add(nums[queue.peek()]);
        }
        return max.stream().mapToInt(Integer::intValue).toArray();
    }
}
