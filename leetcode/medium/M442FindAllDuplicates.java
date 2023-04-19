package medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class M442FindAllDuplicates {

    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> dups = new ArrayList<>();
        Set<Integer> unique = new HashSet<>();

        for (int num : nums) {
            if (unique.contains(num)) {
                dups.add(num);
            } else {
                unique.add(num);
            }
        }
        return dups;
    }

    public List<Integer> findDuplicates2(int[] nums) {
        List<Integer> dups = new ArrayList<>();

        for (int num : nums) {
            nums[Math.abs(num) - 1] *= -1;
        }

        for (int i = 0; i < nums.length; i++) {
            int curr = Math.abs(nums[i]);
            if (nums[curr - 1] > 0) {
                dups.add(curr);
                nums[curr - 1] *= -1;
            }
        }
        return dups;
    }

    public List<Integer> findDuplicates3(int[] nums) {
        List<Integer> dups = new ArrayList<>();

        for (int num : nums) {
            int abs = Math.abs(num);
            if (nums[abs - 1] < 0) {
                dups.add(abs);
            }
            nums[abs - 1] *= -1;
        }
        return dups;
    }
}
