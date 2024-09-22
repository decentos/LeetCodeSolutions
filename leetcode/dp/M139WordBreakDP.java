package dp;

import tree.trie.M139WordBreakTrie;

import java.util.List;
import java.util.Set;

/**
 * Trie solution {@link M139WordBreakTrie}
 */
public class M139WordBreakDP {

    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        Set<String> dict = Set.copyOf(wordDict);
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && dict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }
}
