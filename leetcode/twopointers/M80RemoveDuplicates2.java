package twopointers;

public class M80RemoveDuplicates2 {

    public int removeDuplicates(int[] nums) {
        int p = 1, count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                count++;
            } else {
                count = 1;
            }
            if (count <= 2) {
                nums[p] = nums[i];
                p++;
            }
        }
        return p;
    }
}
