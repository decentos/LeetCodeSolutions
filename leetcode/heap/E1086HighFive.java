package heap;

import java.util.Comparator;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeMap;

public class E1086HighFive {

    public int[][] highFive(int[][] items) {
        Map<Integer, Queue<Integer>> map = new TreeMap<>();

        for (int[] student : items) {
            map.computeIfAbsent(student[0], val -> new PriorityQueue<>(Comparator.reverseOrder())).offer(student[1]);
        }

        int[][] result = new int[map.size()][2];
        int idx = 0;
        for (Map.Entry<Integer, Queue<Integer>> entry : map.entrySet()) {
            int sum = 0;
            for (int i = 0; i < 5; i++) {
                sum += entry.getValue().poll();
            }
            result[idx][0] = entry.getKey();
            result[idx][1] = sum / 5;
            idx++;
        }

        return result;
    }
}
