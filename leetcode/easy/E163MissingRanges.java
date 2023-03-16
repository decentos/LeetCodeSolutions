package easy;

import java.util.ArrayList;
import java.util.List;

public class E163MissingRanges {

    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> ans = new ArrayList<>();
        if (nums.length == 0) {
            format(ans, lower, upper);
            return ans;
        }
        if (nums[0] > lower) {
            format(ans, lower, nums[0] - 1);
        }
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] > 1) {
                format(ans, nums[i - 1] + 1, nums[i] - 1);
            }
        }
        if (nums[nums.length - 1] < upper) {
            format(ans, nums[nums.length - 1] + 1, upper);
        }
        return ans;
    }

    private void format(List<String> ans, int lower, int upper) {
        if (lower == upper) ans.add(String.valueOf(lower));
        else ans.add(String.format("%d->%d", lower, upper));
    }
}
