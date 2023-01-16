package me.decentos.leetcode.easy;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class E1046LastStoneWeight {

    public static int lastStoneWeight(int[] stones) {
        if (stones.length == 1) return stones[0];
        Arrays.sort(stones);
        int last = stones.length - 1;
        int prev = stones.length - 2;
        while (stones[last] != 0) {
            if (stones[prev] == 0) return stones[last];
            stones[last] = stones[last] - stones[prev];
            stones[prev] = 0;
            Arrays.sort(stones);
        }
        return 0;
    }

    public static int lastStoneWeight2(int[] stones) {
        Queue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        for (int i : stones) queue.offer(i);

        while (queue.size() > 1) {
            int first = queue.poll();
            int next = queue.poll();
            if (first != next) {
                queue.offer(first - next);
            }
        }
        return queue.isEmpty() ? 0 : queue.poll();
    }
}
