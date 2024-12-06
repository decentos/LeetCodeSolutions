package greedy;

import java.util.HashSet;
import java.util.Set;

public class M2554MaxNumberRange {

    public int maxCount(int[] banned, int n, int maxSum) {
        Set<Integer> bannedSet = new HashSet<>();
        for (int ban : banned) {
            bannedSet.add(ban);
        }

        int sum = 0, count = 0;
        for (int i = 1; i <= n; i++) {
            if (bannedSet.contains(i)) {
                continue;
            }
            if (sum + i > maxSum) {
                break;
            }
            sum += i;
            count++;
        }
        return count;
    }
}
