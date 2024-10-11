package dp;

public class M45JumpGame2 {

    public int jump(int[] nums) {
        int steps = 0, maxIndex = 0, currMax = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            maxIndex = Math.max(maxIndex, nums[i] + i);

            if (i == currMax) {
                steps++;
                currMax = maxIndex;
            }
        }
        return steps;
    }
}
