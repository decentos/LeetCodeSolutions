package w337;

import java.util.HashSet;
import java.util.Set;

public class M2597BeautifulSubsets {
    private int count;

    public int beautifulSubsets(int[] nums, int k) {
        generate(new HashSet<>(), nums, k, 0);
        return count;
    }

    private void generate(Set<Integer> curr, int[] nums, int k, int index) {
        for (int i = index; i < nums.length; i++) {
            if (curr.contains(nums[i] + k) || curr.contains(nums[i] - k)) continue;
            count++;
            curr.add(nums[i]);
            generate(curr, nums, k, i + 1);
            curr.remove(nums[i]);
        }
    }
}
