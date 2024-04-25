package dp;

public class M2370LongestIdealSubsequence {

    // TLE
    public int longestIdealStringTLE(String s, int k) {
        int n = s.length();
        int[] dp = new int[n];

        for (int i = 0; i < n; i++) {
            dp[i] = 1;

            for (int j = 0; j < i; j++) {
                int diff = Math.abs(s.charAt(i) - s.charAt(j));

                if (diff <= k) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int max = 0;
        for (int i : dp) {
            max = Math.max(max, i);
        }
        return max;
    }

// ===============================================================================

    public int longestIdealString(String s, int k) {
        int max = 0;
        int[] dp = new int[26];

        for (char c : s.toCharArray()) {
            int curr = c - 'a';
            int currMax = 0;

            for (int prev = 0; prev < 26; prev++) {
                int diff = Math.abs(curr - prev);
                if (diff <= k) {
                    currMax = Math.max(currMax, dp[prev]);
                }
            }

            dp[curr] = Math.max(dp[curr], currMax + 1);
            max = Math.max(max, dp[curr]);
        }
        return max;
    }
}
