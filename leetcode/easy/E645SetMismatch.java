package easy;

public class E645SetMismatch {

    public int[] findErrorNums(int[] nums) {
        int n = nums.length;
        int[] ans = new int[2];
        int[] count = new int[n + 1];

        for (int num : nums) count[num]++;

        for (int i = 1; i <= n; i++) {
            int curr = count[i];
            if (curr == 2) ans[0] = i;
            else if (curr == 0) ans[1] = i;
        }
        return ans;
    }

    public int[] findErrorNums2(int[] nums) {
        int[] ans = new int[2];

        for (int num : nums) {
            int abs = Math.abs(num);
            if (nums[abs - 1] < 0) {
                ans[0] = abs;
            } else {
                nums[abs - 1] *= -1;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                ans[1] = i + 1;
                break;
            }
        }
        return ans;
    }
}
