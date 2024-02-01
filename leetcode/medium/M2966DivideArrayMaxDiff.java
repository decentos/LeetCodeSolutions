package medium;

import java.util.Arrays;

public class M2966DivideArrayMaxDiff {

    public int[][] divideArray(int[] nums, int k) {
        int n = nums.length;
        int[][] ans = new int[n / 3][3];
        Arrays.sort(nums);
        int insert = 0;

        for (int i = 0; i < n; i += 3) {
            if (nums[i + 2] - nums[i] > k) {
                return new int[0][0];
            }
            ans[insert][0] = nums[i];
            ans[insert][1] = nums[i + 1];
            ans[insert][2] = nums[i + 2];
            insert++;
        }
        return ans;
    }
}
