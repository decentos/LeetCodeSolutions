package twopointers;

import java.util.Arrays;

public class M948BagTokens {

    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        int n = tokens.length;
        int left = 0, right = n - 1;
        int score = 0;

        while (left <= right) {
            if (power >= tokens[left]) {
                power -= tokens[left];
                left++;
                score++;
            } else if (left < right && score > 0) {
                power += tokens[right];
                right--;
                score--;
            } else {
                break;
            }
        }
        return score;
    }
}
