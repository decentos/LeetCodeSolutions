package slidingwindow;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class M904FruitIntoBaskets {

    public int totalFruit(int[] fruits) {
        int n = fruits.length;
        if (n < 3) return n;

        Map<Integer, Integer> map = new HashMap<>();
        int left = 0, right = 0, max = 0;

        while (right < n) {
            map.put(fruits[right], right++);

            if (map.size() > 2) {
                int delete = Collections.min(map.values());
                map.remove(fruits[delete]);
                left = delete + 1;
            }
            max = Math.max(max, right - left);
        }
        return max;
    }
}
