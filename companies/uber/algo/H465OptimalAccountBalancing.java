package uber.algo;

public class H465OptimalAccountBalancing {

    public int minTransfers(int[][] transactions) {
        int[] balances = new int[13];

        for (int[] transaction : transactions) {
            balances[transaction[0]] -= transaction[2];
            balances[transaction[1]] += transaction[2];
        }

        return dfs(balances, 0);
    }

    private int dfs(int[] balances, int curr) {
        while (curr < balances.length && balances[curr] == 0) {
            curr++;
        }

        if (curr == balances.length) {
            return 0;
        }

        int cost = Integer.MAX_VALUE;
        for (int next = curr + 1; next < balances.length; next++) {
            if (balances[curr] * balances[next] < 0) {
                balances[next] += balances[curr];
                cost = Math.min(cost, dfs(balances, curr + 1) + 1);
                balances[next] -= balances[curr];
            }
        }
        return cost;
    }
}
