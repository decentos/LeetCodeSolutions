package dp;

import java.util.HashMap;
import java.util.Map;

public class M91DecodeWays {

    public int numDecodings_Memp(String s) {
        return backtrack(new HashMap<>(), s, 0);
    }

    private int backtrack(Map<Integer, Integer> memo, String s, int index) {
        if (memo.containsKey(index)) {
            return memo.get(index);
        } else if (index == s.length()) {
            return 1;
        } else if (s.charAt(index) == '0') {
            return 0;
        } else if (index == s.length() - 1) {
            return 1;
        }

        int count = backtrack(memo, s, index + 1);
        if (s.charAt(index) == '1' || s.charAt(index) == '2' && s.charAt(index + 1) < '7') {
            count += backtrack(memo, s, index + 2);
        }
        memo.put(index, count);
        return count;
    }

// ===============================================================================

    public int numDecodings_Dp(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[n] = 1;

        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                continue;
            }

            dp[i] = dp[i + 1];
            if (i < n - 1 && (s.charAt(i) == '1' || s.charAt(i) == '2' && s.charAt(i + 1) < '7')) {
                dp[i] += dp[i + 2];
            }
        }
        return dp[0];
    }

// ===============================================================================

    public int numDecodings_Dp_const(String s) {
        int n = s.length();
        int curr = 1, prev = 0;

        for (int i = n - 1; i >= 0; i--) {
            int temp = s.charAt(i) == '0' ? 0 : curr;

            if (i < n - 1 && (s.charAt(i) == '1' || s.charAt(i) == '2' && s.charAt(i + 1) < '7')) {
                temp += prev;
            }

            prev = curr;
            curr = temp;
        }
        return curr;
    }
}
