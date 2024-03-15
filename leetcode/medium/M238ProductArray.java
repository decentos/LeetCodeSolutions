package medium;

public class M238ProductArray {

    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] left = new int[n];
        left[0] = 1;
        for (int i = 1; i < n; i++) {
            left[i] = left[i - 1] * nums[i - 1];
        }

        int[] right = new int[n];
        right[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            right[i] = right[i + 1] * nums[i + 1];
        }

        for (int i = 0; i < n; i++) {
            nums[i] = left[i] * right[i];
        }
        return nums;
    }

    public int[] productExceptSelf2(int[] nums) {
        int n = nums.length;
        int[] product = new int[n];
        product[0] = 1;
        for (int i = 1; i < n; i++) {
            product[i] = product[i - 1] * nums[i - 1];
        }

        int right = 1;
        for (int i = n - 1; i >= 0; i--) {
            product[i] *= right;
            right *= nums[i];
        }
        return product;
    }
}
