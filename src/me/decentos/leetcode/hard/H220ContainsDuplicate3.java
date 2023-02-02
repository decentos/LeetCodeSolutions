package me.decentos.leetcode.hard;

import java.util.TreeSet;

public class H220ContainsDuplicate3 {

    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j <= i + indexDiff && j < nums.length; j++)
                if (Math.abs(nums[i] - nums[j]) <= valueDiff) return true;
        }
        return false;
    }

    public boolean containsNearbyAlmostDuplicate2(int[] nums, int indexDiff, int valueDiff) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            int curr = nums[i];

            Integer floor = set.floor(curr + valueDiff);
            Integer ceiling = set.ceiling(curr - valueDiff);
            if (floor != null && floor >= curr || ceiling != null && ceiling <= curr) return true;

            set.add(curr);
            if (i >= indexDiff) set.remove(nums[i - indexDiff]);
        }
        return false;
    }
}
