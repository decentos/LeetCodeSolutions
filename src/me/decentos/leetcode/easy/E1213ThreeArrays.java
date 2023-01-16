package me.decentos.leetcode.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class E1213ThreeArrays {

    public List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {
        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : arr1) map.put(i, 1);
        for (int i : arr2) map.merge(i, 1, Integer::sum);
        for (int i : arr3) map.merge(i, 1, Integer::sum);

        map.entrySet().stream()
                .filter(entry -> entry.getValue() == 3)
                .forEach(entry -> result.add(entry.getKey()));

        return result;
    }

    public static List<Integer> arraysIntersection2(int[] arr1, int[] arr2, int[] arr3) {
        List<Integer> result = new ArrayList<>();
        int p1 = 0, p2 = 0, p3 = 0;

        while (p1 < arr1.length && p2 < arr2.length && p3 < arr3.length) {
            int e1 = arr1[p1];
            int e2 = arr2[p2];
            int e3 = arr3[p3];
            if (e1 == e2 && e1 == e3) {
                result.add(e1);
                p1++;
                p2++;
                p3++;
            } else {
                if (e1 < e2) p1++;
                else if (e2 < e3) p2++;
                else p3++;
            }
        }

        return result;
    }
}
