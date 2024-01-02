package w339;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class M2610ConvertArrayInto2D {

    public List<List<Integer>> findMatrix(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int[] freq = new int[nums.length + 1];

        for (int num : nums) {
            if (freq[num] >= ans.size()) {
                ans.add(new ArrayList<>());
            }
            ans.get(freq[num]).add(num);
            freq[num]++;
        }
        return ans;
    }

// ===============================================================================

    public List<List<Integer>> findMatrix2(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Set<Integer> row = new HashSet<>();
        int n = nums.length, count = n;

        while (count > 0) {
            List<Integer> curr = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                int num = nums[i];
                if (num > 0 && !row.contains(num)) {
                    curr.add(num);
                    row.add(num);
                    count--;
                    nums[i] = 0;
                }
            }
            ans.add(curr);
            row.clear();
        }
        return ans;
    }
}
