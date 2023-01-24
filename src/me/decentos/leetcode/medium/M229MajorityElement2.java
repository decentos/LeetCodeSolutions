package me.decentos.leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class M229MajorityElement2 {

    public List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) map.merge(i, 1, Integer::sum);

        int minTimes = nums.length / 3;
        map.forEach((key, value) -> {
            if (value > minTimes) result.add(key);
        });
        return result;
    }

    // Boyer-Moore Voting Algorithm
    public List<Integer> majorityElement2(int[] nums) {
        List<Integer> result = new ArrayList<>();
        Integer candidate1 = null;
        Integer candidate2 = null;
        int count1 = 0;
        int count2 = 0;
        for (int i : nums) {
            if (candidate1 != null && candidate1 == i) {
                count1++;
            } else if (candidate2 != null && candidate2 == i) {
                count2++;
            } else if (count1 == 0) {
                candidate1 = i;
                count1++;
            } else if (count2 == 0) {
                candidate2 = i;
                count2++;
            } else {
                count1--;
                count2--;
            }
        }
        count1 = 0;
        count2 = 0;
        for (int i : nums) {
            if (candidate1 == i) count1++;
            else if (candidate2 == i) count2++;
        }
        if (count1 > nums.length / 3) result.add(candidate1);
        if (count2 > nums.length / 3) result.add(candidate2);
        return result;
    }
}
