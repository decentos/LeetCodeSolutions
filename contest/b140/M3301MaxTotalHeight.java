package b140;

import java.util.Arrays;

public class M3301MaxTotalHeight {

    public long maximumTotalSum(int[] maximumHeight) {
        Arrays.sort(maximumHeight);
        long sum = 0;
        int max = Integer.MAX_VALUE;

        for (int i = maximumHeight.length - 1; i >= 0; i--) {
            if (max > maximumHeight[i]) {
                max = maximumHeight[i];
            } else {
                max--;
            }

            if (max == 0) {
                return -1;
            }

            sum += max;
        }
        return sum;
    }
}
