package dp;

public class M55JumpGame {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int last = n - 1;

        for (int i = last - 1; i >= 0; i--) {
            if (nums[i] + i >= last) {
                last = i;
            }
        }
        return last == 0;
    }
}
