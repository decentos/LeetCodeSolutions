package tree.bst;

public class M96UniqueBST {

    public int numTrees(int n) {
        int[] memo = new int[n + 1];
        return dfs(n, memo);
    }

    private int dfs(int n, int[] memo) {
        if (memo[n] > 0) return memo[n];
        if (n <= 1) return 1;

        int sum = 0;
        for (int i = 1; i <= n; ++i) {
            sum += dfs(i - 1, memo) * dfs(n - i, memo);
        }
        return memo[n] = sum;
    }

// ===============================================================================

    public int numTrees2(int n) {
        int[] counts = new int[n + 1];
        counts[0] = 1;
        counts[1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                counts[i] += counts[j - 1] * counts[i - j];
            }
        }
        return counts[n];
    }
}
