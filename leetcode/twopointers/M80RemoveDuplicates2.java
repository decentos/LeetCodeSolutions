package twopointers;

public class M80RemoveDuplicates2 {

    public int removeDuplicates(int[] nums) {
        int insertIndex = 1, count = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] == nums[i]) {
                count++;
            } else {
                count = 1;
            }

            if (count <= 2) {
                nums[insertIndex++] = nums[i];
            }
        }
        return insertIndex;
    }
}
