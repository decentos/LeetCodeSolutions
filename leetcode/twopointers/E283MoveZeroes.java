package twopointers;

public class E283MoveZeroes {

    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int insertIndex = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] != 0) {
                nums[insertIndex++] = nums[i];
            }
        }

        for (int i = insertIndex; i < n; i++) {
            nums[i] = 0;
        }
    }
}
