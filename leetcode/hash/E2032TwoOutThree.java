package hash;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class E2032TwoOutThree {

    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        Set<Integer> ans = new HashSet<>();
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        for (int num : nums1) {
            set1.add(num);
        }

        for (int num : nums2) {
            if (set1.contains(num)) {
                ans.add(num);
            }
            set2.add(num);
        }

        for (int num : nums3) {
            if (set1.contains(num) || set2.contains(num)) {
                ans.add(num);
            }
        }
        return new ArrayList<>(ans);
    }
}
