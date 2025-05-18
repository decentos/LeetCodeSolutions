package booking;

import java.util.*;

public class M1481UniqueAfterRemovals {

    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> counter = new HashMap<>();
        for (int num : arr) {
            counter.merge(num, 1, Integer::sum);
        }

        List<Integer> freq = new ArrayList<>(counter.values());
        Collections.sort(freq);
        int removed = 0;

        for (int value : freq) {
            if (k >= value) {
                k -= value;
                removed++;
            } else {
                break;
            }
        }
        return freq.size() - removed;
    }

    public int findLeastNumOfUniqueInts2(int[] arr, int k) {
        Map<Integer, Integer> counter = new HashMap<>();
        for (int num : arr) {
            counter.merge(num, 1, Integer::sum);
        }

        int unique = counter.values().size();
        int[] freq = new int[arr.length + 1];
        for (int value : counter.values()) {
            freq[value]++;
        }

        for (int i = 1; i < freq.length; i++) {
            if (freq[i] == 0) {
                continue;
            }

            if (k > freq[i] * i) {
                unique -= freq[i];
                k -= freq[i] * i;
            } else {
                unique -= k / i;
                break;
            }
        }
        return unique;
    }
}
