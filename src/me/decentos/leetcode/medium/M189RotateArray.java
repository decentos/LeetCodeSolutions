package me.decentos.leetcode.medium;

public class M189RotateArray {

    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        if (k == 0) return;

        int[] temp = nums.clone();
        System.arraycopy(temp, n - k, nums, 0, k);
        System.arraycopy(temp, 0, nums, k, n - k);
    }

    public void rotate2(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        if (k == 0) return;

        for (int i = n - k; i > 0; i--) {
            int rotate = i - 1;
            while (rotate < i + k - 1) {
                int temp = nums[rotate];
                nums[rotate] = nums[rotate + 1];
                nums[rotate + 1] = temp;
                rotate++;
            }
        }
    }

    public static void rotate3(int[] nums, int k) {
        int n = nums.length;
        k %= n;
        if (k == 0) return;

        reverse(nums, 0, n - k - 1);
        reverse(nums, n - k, n - 1);
        reverse(nums, 0, n - 1);
    }

    private static void reverse(int[] nums, int l, int r) {
        while (l < r) {
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            l++;
            r--;
        }
    }
}
