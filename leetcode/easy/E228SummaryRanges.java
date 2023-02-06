package easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class E228SummaryRanges {

    public List<String> summaryRanges(int[] nums) {
        if (nums.length == 0) return Collections.emptyList();

        List<String> result = new ArrayList<>();
        int l = 0, r = 0;

        while (r < nums.length) {
            while (r < nums.length - 1 && nums[r] + 1 == nums[r + 1]) {
                r++;
            }
            String range = l == r ? String.valueOf(nums[l]) : nums[l] + "->" + nums[r];
            result.add(range);
            r++;
            l = r;
        }
        return result;
    }
}
