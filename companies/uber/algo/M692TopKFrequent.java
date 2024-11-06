package uber.algo;

import java.util.*;

public class M692TopKFrequent {

    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> freq = new HashMap<>();

        for (String word : words) {
            freq.merge(word, 1, Integer::sum);
        }

        List<String> topK = new ArrayList<>(freq.keySet());
        topK.sort((w1, w2) -> {
            int freq1 = freq.get(w1);
            int freq2 = freq.get(w2);
            if (freq1 == freq2) {
                return w1.compareTo(w2);
            } else {
                return Integer.compare(freq2, freq1);
            }
        });

        return topK.subList(0, k);
    }

// ===============================================================================

    public List<String> topKFrequent2(String[] words, int k) {
        Map<String, Integer> freq = new HashMap<>();

        for (String word : words) {
            freq.merge(word, 1, Integer::sum);
        }

        Queue<String> topK = new PriorityQueue<>((w1, w2) -> {
            int freq1 = freq.get(w1);
            int freq2 = freq.get(w2);
            if (freq1 == freq2) {
                return w2.compareTo(w1);
            } else {
                return Integer.compare(freq1, freq2);
            }
        });

        freq.forEach((word, count) -> {
            topK.offer(word);
            if (topK.size() > k) {
                topK.poll();
            }
        });

        List<String> ans = new ArrayList<>();
        while (!topK.isEmpty()) {
            ans.add(0, topK.poll());
        }
        return ans;
    }
}
