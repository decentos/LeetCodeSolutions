package me.decentos.leetcode.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class E350Intersection2 {

    public static int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums1) map.merge(i, 1, Integer::sum);

        for (int i : nums2) {
            Integer e = map.get(i);
            if (e != null && e > 0) {
                result.add(i);
                e--;
                map.put(i, e);
            }
        }
        return result.stream()
                .mapToInt(it -> it)
                .toArray();
    }
}
