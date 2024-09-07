package hash;

import java.util.HashMap;
import java.util.Map;

public class M260SingleNumber3 {

    public int[] singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) map.merge(num, 1, Integer::sum);

        int[] ans = new int[2];
        int index = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                ans[index] = entry.getKey();
                index++;
            }
        }
        return ans;
    }
}
