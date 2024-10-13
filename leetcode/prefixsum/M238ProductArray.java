package prefixsum;

public class M238ProductArray {

    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] product = new int[n];
        int[] prefix = new int[n];
        int[] suffix = new int[n];
        prefix[0] = 1;
        suffix[n - 1] = 1;

        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] * nums[i - 1];
        }

        for (int i = n - 2; i >= 0; i--) {
            suffix[i] = suffix[i + 1] * nums[i + 1];
        }

        for (int i = 0; i < n; i++) {
            product[i] = prefix[i] * suffix[i];
        }

        return product;
    }

// ===============================================================================

    public int[] productExceptSelf2(int[] nums) {
        int n = nums.length;
        int[] product = new int[n];
        product[0] = 1;
        int suffix = 1;

        for (int i = 1; i < n; i++) {
            product[i] = product[i - 1] * nums[i - 1];
        }

        for (int i = n - 1; i >= 0; i--) {
            product[i] *= suffix;
            suffix *= nums[i];
        }

        return product;
    }
}
