package dp;

public class M1143LongestSubsequence {
    private int[][] memo;
    private String text1;
    private String text2;

    public int longestCommonSubsequence(String text1, String text2) {
        memo = new int[text1.length() + 1][text2.length() + 1];
        for (int i = 0; i < text1.length(); i++) {
            for (int j = 0; j < text2.length(); j++) {
                memo[i][j] = -1;
            }
        }
        this.text1 = text1;
        this.text2 = text2;
        return memoSolve(0, 0);
    }

    private int memoSolve(int p1, int p2) {
        // Check whether we've already solved this subproblem.
        // This also covers the base cases where p1 == text1.length or p2 == text2.length.
        if (memo[p1][p2] != -1) return memo[p1][p2];

        // Option 1: we don't include text1[p1] in the solution.
        int option1 = memoSolve(p1 + 1, p2);

        // Option 2: We include text1[p1] in the solution, as long as a match for it in text2 at or after p2 exists.
        int firstOccurrence = text2.indexOf(text1.charAt(p1), p2);
        int option2 = 0;
        if (firstOccurrence != -1) option2 = 1 + memoSolve(p1 + 1, firstOccurrence + 1);

        // Add the best answer to the memo before returning it.
        memo[p1][p2] = Math.max(option1, option2);
        return memo[p1][p2];
    }

    private int memoSolve2(int p1, int p2) {
        // Check whether we've already solved this subproblem.
        // This also covers the base cases where p1 == text1.length or p2 == text2.length.
        if (memo[p1][p2] != -1) return memo[p1][p2];

        // Recursive cases.
        int answer;
        if (text1.charAt(p1) == text2.charAt(p2)) {
            answer = 1 + memoSolve2(p1 + 1, p2 + 1);
        } else {
            answer = Math.max(memoSolve2(p1, p2 + 1), memoSolve2(p1 + 1, p2));
        }

        // Add the best answer to the memo before returning it.
        memo[p1][p2] = answer;
        return memo[p1][p2];
    }

    // dp
    public int longestCommonSubsequence2(String text1, String text2) {
        int[][] dpGrid = new int[text1.length() + 1][text2.length() + 1];

        // Iterate up each column, starting from the last one.
        for (int col = text2.length() - 1; col >= 0; col--) {
            for (int row = text1.length() - 1; row >= 0; row--) {
                // If the corresponding characters for this cell are the same...
                if (text1.charAt(row) == text2.charAt(col)) {
                    dpGrid[row][col] = 1 + dpGrid[row + 1][col + 1];
                    // Otherwise they must be different...
                } else {
                    dpGrid[row][col] = Math.max(dpGrid[row + 1][col], dpGrid[row][col + 1]);
                }
            }
        }
        // The original problem's answer is in dp_grid[0][0]. Return it.
        return dpGrid[0][0];
    }

    // dp space optimize
    public int longestCommonSubsequence3(String text1, String text2) {

        // If text1 doesn't reference the shortest string, swap them.
        if (text2.length() < text1.length()) {
            String temp = text1;
            text1 = text2;
            text2 = temp;
        }

        // The previous and current column starts with all 0's and like
        // before is 1 more than the length of the first word.
        int[] previous = new int[text1.length() + 1];
        int[] current = new int[text1.length() + 1];

        // Iterate through each column, starting from the last one.
        for (int col = text2.length() - 1; col >= 0; col--) {
            for (int row = text1.length() - 1; row >= 0; row--) {
                if (text1.charAt(row) == text2.charAt(col)) {
                    current[row] = 1 + previous[row + 1];
                } else {
                    current[row] = Math.max(previous[row], current[row + 1]);
                }
            }
            // The current column becomes the previous one, and vice versa.
            int[] temp = previous;
            previous = current;
            current = temp;
        }

        // The original problem's answer is in previous[0]. Return it.
        return previous[0];
    }
}
