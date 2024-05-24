package backtracking;

import java.util.ArrayList;
import java.util.List;

public class M131PalindromePartitioning {

    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        boolean[][] memo = new boolean[s.length()][s.length()];
        backtrack(ans, new ArrayList<>(), memo, s, 0);
        return ans;
    }

    private void backtrack(List<List<String>> ans, List<String> curr, boolean[][] memo, String s, int index) {
        if (index == s.length()) {
            ans.add(new ArrayList<>(curr));
            return;
        }

        for (int end = index; end < s.length(); end++) {
            if (memo[index][end] || isPalindromic(s, index, end)) {
                memo[index][end] = true;
                curr.add(s.substring(index, end + 1));
                backtrack(ans, curr, memo, s, end + 1);
                curr.removeLast();
            }
        }
    }

    private boolean isPalindromic(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
