package greedy;

import java.util.HashMap;
import java.util.Map;

public class M1481UniqueAfterRemovals {

    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> unique = new HashMap<>();
        int[] count = new int[arr.length + 1];

        for (int i : arr) {
            unique.merge(i, 1, Integer::sum);
        }

        for (int i : unique.values()) {
            count[i]++;
        }

        int ans = unique.size();
        for (int i = 0; i < count.length; i++) {
            if (count[i] == 0) {
                continue;
            }

            if (k - i * count[i] >= 0) {
                ans -= count[i];
                k -= i * count[i];
            } else {
                ans -= k / i;
                return ans;
            }
        }
        return 0;
    }
}
