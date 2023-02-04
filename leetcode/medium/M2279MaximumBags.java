package medium;

import java.util.Arrays;

public class M2279MaximumBags {

    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int n = capacity.length, count = 0;
        int[] freeSpace = new int[n];

        for (int i = 0; i < capacity.length; i++) {
            freeSpace[i] = capacity[i] - rocks[i];
        }
        Arrays.sort(freeSpace);

        for (int i : freeSpace) {
            if (additionalRocks >= i) {
                additionalRocks -= i;
                count++;
            } else {
                break;
            }
        }
        return count;
    }
}
