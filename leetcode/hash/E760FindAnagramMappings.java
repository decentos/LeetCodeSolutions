package hash;

import java.util.HashMap;
import java.util.Map;

public class E760FindAnagramMappings {

    public int[] anagramMappings(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int[] ans = new int[n];
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.put(nums2[i], i);
        }

        for (int i = 0; i < n; i++) {
            ans[i] = map.get(nums1[i]);
        }
        return ans;
    }
}
