package me.decentos.leetcode.medium;

import java.util.PriorityQueue;
import java.util.Queue;

public class M973ClosestPoints {

    public int[][] kClosest(int[][] points, int k) {
        int[][] result = new int[k][2];
        Queue<int[]> heap = new PriorityQueue<>((a, b) -> (b[0] * b[0] + b[1] * b[1]) - (a[0] * a[0] + a[1] * a[1]));
        for (int[] i : points) {
            heap.offer(i);
            if (heap.size() > k) heap.poll();
        }
        for (int i = 0; i < k; i++) {
            result[i] = heap.poll();
        }
        return result;
    }
}
