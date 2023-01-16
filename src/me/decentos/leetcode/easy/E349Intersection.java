package me.decentos.leetcode.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class E349Intersection {

    public static int[] intersection(int[] nums1, int[] nums2) {
        List<Integer> result = new ArrayList<>();
        int first = 0, second = 0;
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        while (first < nums1.length && second < nums2.length) {
            int element1 = nums1[first];
            int element2 = nums2[second];
            if (element1 == element2 && !result.contains(element1)) {
                result.add(element1);
                first++;
                second++;
            } else if (element1 == element2) {
                first++;
                second++;
            } else if (element1 > element2) {
                second++;
            } else {
                first++;
            }
        }
        return result.stream()
                .mapToInt(it -> it)
                .toArray();
    }

    public int[] intersection2(int[] nums1, int[] nums2) {
        List<Integer> result = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for (int i : nums1) set.add(i);

        for (int i : nums2) {
            if (set.contains(i) && !result.contains(i)) {
                result.add(i);
            }
        }
        return result.stream()
                .mapToInt(it -> it)
                .toArray();
    }
}
