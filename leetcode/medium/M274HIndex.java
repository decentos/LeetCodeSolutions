package medium;

import java.util.Arrays;

public class M274HIndex {

    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int hIndex = 0, curr = citations.length - 1;

        while (curr >= 0 && citations[curr] > hIndex) {
            hIndex++;
            curr--;
        }
        return hIndex;
    }

// ===============================================================================

    public int hIndex2(int[] citations) {
        int n = citations.length;
        int[] count = new int[n + 1];

        for (int citation : citations) {
            count[Math.min(citation, n)]++;
        }

        int curr = 0;
        for (int i = n; i >= 0; i--) {
            curr += count[i];
            if (curr >= i) {
                return i;
            }
        }
        return 0;
    }
}
