package b141;

import java.util.Arrays;
import java.util.List;

public class E3314MinBitwiseArray {

    public int[] minBitwiseArray(List<Integer> nums) {
        int n = nums.size();
        int[] ans = new int[n];
        Arrays.fill(ans, -1);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= nums.get(i); j++) {
                if ((j | (j + 1)) == nums.get(i)) {
                    ans[i] = j;
                    break;
                }
            }
        }
        return ans;
    }
}
