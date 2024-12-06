package greedy;

import java.util.Arrays;

public class M2557MaxNumberRange2 {

    public int maxCount(int[] banned, int n, long maxSum) {
        Arrays.sort(banned);

        long currSum = 0;
        int banIndex = 0, count = 0;

        for (int i = 1; i <= n; i++) {
            if (banIndex < banned.length && banned[banIndex] == i) {
                banIndex++;
                continue;
            }
            if (currSum + i > maxSum) {
                break;
            }

            currSum += i;
            count++;
        }
        return count;
    }
}
