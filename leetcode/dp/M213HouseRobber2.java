package dp;

public class M213HouseRobber2 {

    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];

        int first = findMax(nums, 0, n - 1);
        int second = findMax(nums, 1, n);
        return Math.max(first, second);
    }

    private int findMax(int[] nums, int start, int end) {
        int prev1 = 0, prev2 = 0, curr = 0;

        for (int i = start; i < end; i++) {
            curr = Math.max(prev2, prev1 + nums[i]);
            prev1 = prev2;
            prev2 = curr;
        }
        return curr;
    }
}
