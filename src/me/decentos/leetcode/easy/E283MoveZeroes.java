package me.decentos.leetcode.easy;

public class E283MoveZeroes {

    public void moveZeroes(int[] nums) {
        int zero = -1;
        for (int i = 0; i < nums.length; i++) {
            if (zero == -1 && nums[i] == 0) {
                zero = i;
            } else if (zero != -1 && nums[i] != 0) {
                nums[zero] = nums[i];
                nums[i] = 0;
                zero++;
            }
        }
    }

    public void moveZeroes2(int[] nums) {
        int zeroIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int zero = nums[zeroIndex];
                nums[zeroIndex] = nums[i];
                nums[i] = zero;
                zeroIndex++;
            }
        }
    }
}
