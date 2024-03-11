package twopointers;

import java.util.HashSet;
import java.util.Set;

public class E349Intersection {

    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        for (int num : nums1) {
            set1.add(num);
        }
        Set<Integer> ans = new HashSet<>();
        for (int num : nums2) {
            if (set1.contains(num)) {
                ans.add(num);
            }
        }
        return ans.stream()
                .mapToInt(a -> a)
                .toArray();
    }
}
