package binarysearch;

import java.util.Arrays;

public class M2300PairsSpellsPotions {

    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int n = spells.length, m = potions.length;
        int[] pairs = new int[n];
        Arrays.sort(potions);

        for (int i = 0; i < n; i++) {
            int low = 0, high = m - 1;

            while (low <= high) {
                int mid = (low + high) / 2;
                long product = (long) potions[mid] * spells[i];

                if (product >= success) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            pairs[i] = m - low;
        }
        return pairs;
    }
}
