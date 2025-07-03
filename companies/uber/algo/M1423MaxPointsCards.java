package uber.algo;

public class M1423MaxPointsCards {

    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length, left = 0, right = n - k;
        int maxSum = 0, currSum = 0;

        for (int i = right; i < n; i++) {
            currSum += cardPoints[i];
        }
        maxSum = currSum;

        while (right < n) {
            currSum += cardPoints[left] - cardPoints[right];
            maxSum = Math.max(maxSum, currSum);
            left++;
            right++;
        }
        return maxSum;
    }
}
