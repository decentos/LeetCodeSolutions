package hash;

import java.util.HashMap;
import java.util.Map;

public class M1814CountNicePairs {

    private static final int MODULO = 1_000_000_007;

    public int countNicePairs(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> reversedDiffMap = new HashMap<>();
        int pairsCount = 0;

        for (int i = n - 1; i >= 0; i--) {
            int num = nums[i];
            int reversedNum = 0;

            while (num > 0) {
                reversedNum = reversedNum * 10 + num % 10;
                num /= 10;
            }

            int diff = nums[i] - reversedNum;
            pairsCount = (pairsCount + reversedDiffMap.merge(diff, 1, Integer::sum) - 1) % MODULO;

        }
        return pairsCount;
    }
}
