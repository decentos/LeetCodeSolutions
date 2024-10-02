package hash;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class E1331RankTransform {

    public int[] arrayRankTransform(int[] arr) {
        int n = arr.length;
        int rank = 1;
        int[] ranked = new int[n];
        Map<Integer, Integer> numToRank = new HashMap<>();
        Set<Integer> sortedSet = new TreeSet<>();

        for (int num : arr) {
            sortedSet.add(num);
        }

        for (int num : sortedSet) {
            numToRank.put(num, rank);
            rank++;
        }

        for (int i = 0; i < n; i++) {
            ranked[i] = numToRank.get(arr[i]);
        }

        return ranked;
    }
}
