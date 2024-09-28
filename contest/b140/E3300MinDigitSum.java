package b140;

public class E3300MinDigitSum {

    public int minElement(int[] nums) {
        int n = nums.length;
        int[] sums = new int[n];
        for (int i = 0; i < n; i++) {
            sums[i] = digitSum(nums[i]);
        }

        int min = Integer.MAX_VALUE;
        for (int sum : sums) {
            min = Math.min(min, sum);
        }
        return min;
    }

    private int digitSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}
