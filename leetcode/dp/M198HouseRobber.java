package dp;

public class M198HouseRobber {

    public int rob(int[] nums) {
        int n = nums.length;
        int prev = 0, curr = nums[0];
        for (int i = 1; i < n; i++) {
            int next = Math.max(curr, nums[i] + prev);
            prev = curr;
            curr = next;
        }
        return curr;
    }
}
