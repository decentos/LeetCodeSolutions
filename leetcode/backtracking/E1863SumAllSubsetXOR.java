package backtracking;

public class E1863SumAllSubsetXOR {

    public int subsetXORSum(int[] nums) {
        return backtrack(nums, 0, 0);
    }

    private int backtrack(int[] nums, int index, int sum) {
        if (index == nums.length) {
            return sum;
        }

        int withCurr = backtrack(nums, index + 1, sum ^ nums[index]);
        int withoutCurr = backtrack(nums, index + 1, sum);

        return withCurr + withoutCurr;
    }
}
