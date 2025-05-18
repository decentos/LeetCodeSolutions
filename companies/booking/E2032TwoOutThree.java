package booking;

import java.util.ArrayList;
import java.util.List;

public class E2032TwoOutThree {

    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        List<Integer> ans = new ArrayList<>();
        int[][] count = new int[3][101];

        for (int num : nums1) {
            count[0][num] = 1;
        }
        for (int num : nums2) {
            count[1][num] = 1;
        }
        for (int num : nums3) {
            count[2][num] = 1;
        }

        for (int i = 0; i < count[0].length; i++) {
            if (count[0][i] + count[1][i] + count[2][i] >= 2) {
                ans.add(i);
            }
        }
        return ans;
    }
}
