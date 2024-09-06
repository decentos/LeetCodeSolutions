package prefixsum;

public class E724PivotIndex {

    public int pivotIndex(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        int leftSum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum -= nums[i];
            if (leftSum == sum) {
                return i;
            }
            leftSum += nums[i];
        }
        return -1;
    }
}
