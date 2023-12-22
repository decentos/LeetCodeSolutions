package string;

public class E1422MaxScoreAfterSplit {

    public int maxScore(String s) {
        int ones = 0, zeros = 0;
        int score = 0, n = s.length();

        for (char c : s.toCharArray()) {
            if (c == '1') {
                ones++;
            }
        }

        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == '0') {
                zeros++;
            } else {
                ones--;
            }

            score = Math.max(score, zeros + ones);
        }

        return score;
    }

// ===============================================================================

    public int maxScore2(String s) {
        int ones = 0, zeros = 0, n = s.length();
        int best = Integer.MIN_VALUE;

        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == '1') {
                ones++;
            } else {
                zeros++;
            }

            best = Math.max(best, zeros - ones);
        }

        if (s.charAt(n - 1) == '1') {
            ones++;
        }
        return best + ones;
    }
}
