package dp;

public class M198HouseRobber {

    public int rob(int[] nums) {
        int n = nums.length;
        int prev = 0, curr = nums[0];

        for (int i = 1; i < n; i++) {
            int next = Math.max(curr, prev + nums[i]);
            prev = curr;
            curr = next;
        }
        return curr;
    }
}
