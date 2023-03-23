package backtracking;

import java.util.ArrayList;
import java.util.List;

public class M131PalindromePartitioning {

    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        boolean[][] memo = new boolean[s.length()][s.length()];
        generate(ans, new ArrayList<>(), s, 0, memo);
        return ans;
    }

    private void generate(List<List<String>> ans, List<String> curr, String s, int index, boolean[][] memo) {
        if (index == s.length()) {
            ans.add(new ArrayList<>(curr));
            return;
        }

        for (int end = index; end < s.length(); end++) {
            if (memo[index][end] || isPalindrome(s, index, end)) {
                memo[index][end] = true;
                curr.add(s.substring(index, end + 1));
                generate(ans, curr, s, end + 1, memo);
                curr.remove(curr.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }
}
