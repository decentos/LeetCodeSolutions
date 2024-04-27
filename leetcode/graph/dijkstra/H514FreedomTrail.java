package graph.dijkstra;

import java.util.*;

public class H514FreedomTrail {

    public int findRotateSteps(String ring, String key) {
        int ringLen = ring.length(), keyLen = key.length();
        int totalSteps = 0;
        Map<Character, List<Integer>> charToIndices = new HashMap<>();
        for (int i = 0; i < ringLen; i++) {
            char curr = ring.charAt(i);
            charToIndices.computeIfAbsent(curr, val -> new ArrayList<>()).add(i);
        }
        boolean[][] visited = new boolean[ringLen][keyLen];
        Queue<int[]> heap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        heap.offer(new int[]{0, 0, 0});

        while (!heap.isEmpty()) {
            int[] step = heap.poll();
            totalSteps = step[0];
            int ringIndex = step[1];
            int keyIndex = step[2];

            if (keyIndex == keyLen) {
                break;
            }

            if (!visited[ringIndex][keyIndex]) {
                visited[ringIndex][keyIndex] = true;
            } else {
                continue;
            }

            List<Integer> indices = charToIndices.get(key.charAt(keyIndex));
            for (int nextRingIndex : indices) {
                int clockwiseSteps = Math.abs(ringIndex - nextRingIndex);
                int anticlockwiseSteps = ringLen - clockwiseSteps;
                int minSteps = Math.min(clockwiseSteps, anticlockwiseSteps);

                heap.offer(new int[]{totalSteps + minSteps, nextRingIndex, keyIndex + 1});
            }
        }
        return totalSteps + keyLen;
    }
}
