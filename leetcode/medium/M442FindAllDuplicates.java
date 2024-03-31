package medium;

import java.util.ArrayList;
import java.util.List;

public class M442FindAllDuplicates {

    public List<Integer> findDuplicates(int[] nums) {
        int n = nums.length;
        List<Integer> dups = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int position = Math.abs(nums[i]) - 1;
            if (nums[position] < 0) {
                dups.add(position + 1);
            } else {
                nums[position] *= -1;
            }
        }
        return dups;
    }
}
