package dp;

public class M55JumpGame {
    private static boolean isLast = false;

    public static boolean canJump(int[] nums) {
        boolean[] seen = new boolean[nums.length];
        helper(nums, 0, seen);
        return isLast;
    }

    private static void helper(int[] nums, int position, boolean[] seen) {
        if (seen[position] || isLast) return;
        seen[position] = true;

        if (position == nums.length - 1 || nums[position] >= nums.length - position) {
            isLast = true;
            return;
        }
        for (int i = nums[position]; i > 0; i--) {
            helper(nums, position + i, seen);
        }
    }

    public boolean canJump2(int[] nums) {
        int lastPos = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i + nums[i] >= lastPos) {
                lastPos = i;
            }
        }
        return lastPos == 0;
    }
}
