package dp;

public class M1884EggDrop {

    public int twoEggDrop(int n) {
        int moves = 1, floor = 1;
        while (floor < n) {
            moves++;
            floor += moves;
        }
        return moves;
    }

    public int twoEggDrop2(int n) {
        int eggs = 2, moves = 0;
        int[][] dp = new int[n + 1][eggs + 1];

        while (dp[moves][eggs] < n) {
            moves++;
            for (int i = 1; i <= eggs; i++) {
                dp[moves][i] = 1 + dp[moves - 1][i] + dp[moves - 1][i - 1];
            }
        }
        return moves;
    }

    public int twoEggDrop3(int n) {
        int eggs = 2, moves = 0;
        int[] dp = new int[eggs + 1];

        while (dp[eggs] < n) {
            moves++;
            for (int i = eggs; i > 0; i--) {
                dp[i] += dp[i - 1] + 1;
            }
        }
        return moves;
    }
}
