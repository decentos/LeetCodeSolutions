package hash;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class E2215FindDiffArrays {

    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> unique1 = new HashSet<>();
        Set<Integer> unique2 = new HashSet<>();
        List<Integer> answer1 = new ArrayList<>();
        List<Integer> answer2 = new ArrayList<>();

        for (int num : nums1) {
            unique1.add(num);
        }

        for (int num : nums2) {
            unique2.add(num);
        }

        for (int num : unique1) {
            if (!unique2.contains(num)) {
                answer1.add(num);
            }
        }

        for (int num : unique2) {
            if (!unique1.contains(num)) {
                answer2.add(num);
            }
        }

        return List.of(answer1, answer2);
    }
}
