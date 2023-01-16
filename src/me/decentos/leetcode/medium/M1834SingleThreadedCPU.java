package me.decentos.leetcode.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class M1834SingleThreadedCPU {

    public static int[] getOrder(int[][] tasks) {
        int[] seq = new int[tasks.length];
        Queue<int[]> queue = new PriorityQueue<>((a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);
        List<Process> list = new ArrayList<>();
        for (int i = 0; i < tasks.length; i++) {
            list.add(new Process(tasks[i][0], tasks[i][1], i));
        }
        Collections.sort(list);

        int listIndex = 0, seqIndex = 0, time = 0;
        while (seqIndex < seq.length) {
            while (listIndex < list.size() && time >= list.get(listIndex).startTime) {
                Process next = list.get(listIndex);
                queue.offer(new int[]{next.processTime, next.index});
                listIndex++;
            }

            if (queue.isEmpty()) {
                time = list.get(listIndex).startTime;
                continue;
            }

            int[] cur = queue.poll();
            seq[seqIndex] = cur[1];
            seqIndex++;
            time += cur[0];
        }

        return seq;
    }

    private static class Process implements Comparable<Process> {
        int startTime;
        int processTime;
        int index;

        public Process(int startTime, int processTime, int index) {
            this.startTime = startTime;
            this.processTime = processTime;
            this.index = index;
        }

        @Override
        public int compareTo(Process o) {
            return Integer.compare(startTime, o.startTime);
        }
    }
}
