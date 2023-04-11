package dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class M300LongestIncreasingSubsequence {

    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int max = 0;
        for (int i : dp) max = Math.max(max, i);
        return max;
    }

    public int lengthOfLIS2(int[] nums) {
        int n = nums.length;
        List<Integer> seq = new ArrayList<>();
        seq.add(nums[0]);

        for (int i = 1; i < n; i++) {
            int curr = nums[i];
            int higher = seq.get(seq.size() - 1);
            if (curr > higher) {
                seq.add(curr);
            } else {
                int index = getIndex(seq, curr);
                seq.set(index, curr);
            }
        }
        return seq.size();
    }

    private int getIndex(List<Integer> seq, int curr) {
        int left = 0, right = seq.size() - 1;

        while (left < right) {
            int mid = (left + right) / 2;

            if (curr > seq.get(mid)) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
