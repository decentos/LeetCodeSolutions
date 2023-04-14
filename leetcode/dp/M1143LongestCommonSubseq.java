package dp;

public class M1143LongestCommonSubseq {

    public int longestCommonSubsequence(String text1, String text2) {
        int l1 = text1.length(), l2 = text2.length();
        int[][] dp = new int[l1 + 1][l2 + 1];

        for (int t1 = l1 - 1; t1 >= 0; t1--) {
            for (int t2 = l2 - 1; t2 >= 0; t2--) {
                if (text1.charAt(t1) == text2.charAt(t2)) {
                    dp[t1][t2] = 1 + dp[t1 + 1][t2 + 1];
                } else {
                    dp[t1][t2] = Math.max(dp[t1 + 1][t2], dp[t1][t2 + 1]);
                }
            }
        }
        return dp[0][0];
    }
}
