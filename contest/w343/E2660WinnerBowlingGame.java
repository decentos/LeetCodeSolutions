package w343;

public class E2660WinnerBowlingGame {

    public int isWinner(int[] player1, int[] player2) {
        int score1 = score(player1);
        int score2 = score(player2);

        if (score1 > score2) return 1;
        else if (score2 > score1) return 2;
        else return 0;
    }

    private int score(int[] player) {
        int score = 0;
        for (int i = 0; i < player.length; i++) {
            int curr = player[i];
            if (i > 0 && player[i - 1] == 10) score += curr * 2;
            else if (i > 1 && player[i - 2] == 10) score += curr * 2;
            else score += curr;
        }
        return score;
    }
}
