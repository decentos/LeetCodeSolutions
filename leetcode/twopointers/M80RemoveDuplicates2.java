package twopointers;

public class M80RemoveDuplicates2 {

    public int removeDuplicates(int[] nums) {
        int insertIndex = 1, count = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] != nums[i]) {
                nums[insertIndex++] = nums[i];
                count = 1;
            } else if (count == 1) {
                nums[insertIndex++] = nums[i];
                count++;
            }
        }
        return insertIndex;
    }
}
