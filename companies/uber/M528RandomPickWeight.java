package uber;

public class M528RandomPickWeight {

    private final int[] prefixSum;
    private int totalSum;

    public M528RandomPickWeight(int[] w) {
        prefixSum = new int[w.length];
        totalSum = 0;

        for (int i = 0; i < w.length; i++) {
            prefixSum[i] = totalSum + w[i];
            totalSum += w[i];
        }
    }

    public int pickIndex() {
        double target = totalSum * Math.random();
        int left = 0, right = prefixSum.length - 1;

        while (left < right) {
            int mid = (left + right) / 2;

            if (target > prefixSum[mid]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
