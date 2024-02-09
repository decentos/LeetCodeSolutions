package dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class M368LargestDivisibleSubset {

    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<List<Integer>> sets = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);

        for (int i = 0; i < n; i++) {
            sets.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            List<Integer> max = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0 && sets.get(j).size() > max.size()) {
                    max = sets.get(j);
                }
            }
            sets.get(i).addAll(max);
            sets.get(i).add(nums[i]);
        }

        List<Integer> max = new ArrayList<>();
        for (List<Integer> curr : sets) {
            if (curr.size() > max.size()) {
                max = curr;
            }
        }
        return max;
    }
}
