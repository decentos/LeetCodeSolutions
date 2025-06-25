package uber.algo;

import java.util.*;

public class M347TopFrequentElements {

    public int[] topKFrequent(int[] nums, int k) {
        int[] topK = new int[k];
        Queue<int[]> heap = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        Map<Integer, Integer> counter = new HashMap<>();

        for (int num : nums) {
            counter.merge(num, 1, Integer::sum);
        }

        counter.forEach((key, value) -> {
            if (heap.size() < k) {
                heap.offer(new int[]{key, value});
            } else if (heap.peek()[1] < value) {
                heap.poll();
                heap.offer(new int[]{key, value});
            }
        });

        for (int i = 0; i < k; i++) {
            topK[i] = heap.poll()[0];
        }
        return topK;
    }

// ===============================================================================

    public int[] topKFrequent2(int[] nums, int k) {
        int[] topK = new int[k];
        List<Integer>[] buckets = new List[nums.length + 1];
        Map<Integer, Integer> counter = new HashMap<>();

        for (int num : nums) {
            counter.merge(num, 1, Integer::sum);
        }

        counter.forEach((key, value) -> {
           if (buckets[value] == null) {
               buckets[value] = new ArrayList<>();
           }
            buckets[value].add(key);
        });

        int insertIndex = 0;
        for (int i = buckets.length - 1; i >= 0; i--) {
            List<Integer> bucket = buckets[i];
            
            if (bucket == null) {
                continue;
            }

            for (int element : bucket) {
                topK[insertIndex++] = element;
                if (insertIndex == k) {
                    return topK;
                }
            }
        }
        return topK;
    }
}
