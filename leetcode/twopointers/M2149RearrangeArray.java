package twopointers;

public class M2149RearrangeArray {

    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        int positiveIndex = 0, negativeIndex = 1;

        for (int num : nums) {
            if (num > 0) {
                ans[positiveIndex] = num;
                positiveIndex += 2;
            } else {
                ans[negativeIndex] = num;
                negativeIndex += 2;
            }
        }
        return ans;
    }
}
