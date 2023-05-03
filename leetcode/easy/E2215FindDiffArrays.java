package easy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class E2215FindDiffArrays {

    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<List<Integer>> ans = new ArrayList<>();

        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for (int num : nums1) set1.add(num);
        for (int num : nums2) set2.add(num);

        List<Integer> unique1 = new ArrayList<>();
        List<Integer> unique2 = new ArrayList<>();
        for (int num : set1) {
            if (!set2.contains(num)) unique1.add(num);
        }
        for (int num : set2) {
            if (!set1.contains(num)) unique2.add(num);
        }

        ans.add(unique1);
        ans.add(unique2);
        return ans;
    }
}
