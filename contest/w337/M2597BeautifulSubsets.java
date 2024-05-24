package w337;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class M2597BeautifulSubsets {
    public int beautifulSubsets(int[] nums, int k) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        generate(ans, new ArrayList<>(), nums, k, 0);
        return ans.size();
    }

    private void generate(List<List<Integer>> ans, List<Integer> curr, int[] nums, int k, int index) {
        if (index == nums.length) {
            if (!curr.isEmpty()) {
                ans.add(new ArrayList<>(curr));
            }
            return;
        }

        if (!curr.contains(nums[index] - k)) {
            curr.add(nums[index]);
            generate(ans, curr, nums, k, index + 1);
            curr.removeLast();
        }
        generate(ans, curr, nums, k, index + 1);
    }
}
