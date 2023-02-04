package dp;

import java.util.HashMap;
import java.util.Map;

public class M790DominoTromino {
    private final int MOD = 1_000_000_007;
    private final Map<Integer, Long> fullCache = new HashMap<>();
    private final Map<Integer, Long> partCache = new HashMap<>();

    public int numTilings(int n) {
        return (int) (fullTilling(n));
    }

    private long fullTilling(int n) {
        if (fullCache.containsKey(n)) {
            return fullCache.get(n);
        }
        long count;
        if (n == 1) {
            count = 1L;
        } else if (n == 2) {
            count = 2L;
        } else {
            count = (fullTilling(n - 1) + fullTilling(n - 2) + 2 * partTilling(n - 1)) % MOD;
        }
        fullCache.put(n, count);
        return count;
    }

    private long partTilling(int n) {
        if (partCache.containsKey(n)) {
            return partCache.get(n);
        }
        long count;
        if (n == 2) {
            count = 1L;
        } else {
            count = (partTilling(n - 1) + fullTilling(n - 2)) % MOD;
        }
        partCache.put(n, count);
        return count;
    }
}
