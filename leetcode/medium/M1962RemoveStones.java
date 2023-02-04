package medium;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class M1962RemoveStones {

    public int minStoneSum(int[] piles, int k) {
        Queue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i : piles) queue.offer(i);

        while (!queue.isEmpty() && k > 0) {
            int max = queue.poll();
            int floor = max / 2;
            queue.offer(max - floor);
            k--;
        }
        return queue.stream().reduce(Integer::sum).orElse(0);
    }
}
