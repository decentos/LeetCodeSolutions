package w338;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class M2602MinOperationsArraysEqual {

    public List<Long> minOperations(int[] nums, int[] queries) {
        int n = nums.length;
        List<Long> ans = new ArrayList<>();
        Arrays.sort(nums);

        long[] prefixSum = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i - 1];
        }

        for (int query : queries) {
            int index = binarySearch(nums, query);
            long increment = (long) query * index - prefixSum[index];
            long decrement = prefixSum[n] - prefixSum[index] - (long) query * (n - index);
            ans.add(increment + decrement);
//            ans.add((long) query * (2L * index - n) + prefixSum[n] - 2 * prefixSum[index]);
        }

        return ans;
    }

    private int binarySearch(int[] nums, int query) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= query) right = mid - 1;
            else left = mid + 1;
        }
        return left;
    }
}
