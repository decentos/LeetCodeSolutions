package me.decentos.leetcode.easy;

public class E905SortArrayParity {

    public int[] sortArrayByParity(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            while (l < r && nums[l] % 2 == 0) l++;
            while (r > l && nums[r] % 2 == 1) r--;
            if (l < r) {
                int temp = nums[l];
                nums[l] = nums[r];
                nums[r] = temp;
            }
        }
        return nums;
    }

    public int[] sortArrayByParity2(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int modL = nums[l] % 2;
            int modR = nums[r] % 2;
            if (modL > modR) {
                int temp = nums[l];
                nums[l] = nums[r];
                nums[r] = temp;
            }
            if (modL == 0) l++;
            if (modR == 1) r--;
        }
        return nums;
    }
}
