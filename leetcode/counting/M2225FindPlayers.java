package counting;

import java.util.*;

public class M2225FindPlayers {

    public List<List<Integer>> findWinners(int[][] matches) {
        List<List<Integer>> ans = new ArrayList<>();
        Set<Integer> winners = new HashSet<>();
        Set<Integer> losers = new HashSet<>();
        Set<Integer> oneLosses = new HashSet<>();

        for (int[] match : matches) {
            if (!losers.contains(match[1])) {
                losers.add(match[1]);
                oneLosses.add(match[1]);
            } else {
                oneLosses.remove(match[1]);
            }

            winners.remove(match[1]);
            if (!losers.contains(match[0])) {
                winners.add(match[0]);
            }
        }

        ans.add(winners.stream().sorted().toList());
        ans.add(oneLosses.stream().sorted().toList());
        return ans;
    }

// ===============================================================================

    public List<List<Integer>> findWinners2(int[][] matches) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> zeroLoss = new ArrayList<>();
        List<Integer> oneLoss = new ArrayList<>();
        ans.add(zeroLoss);
        ans.add(oneLoss);
        int[] counter = new int[100_001];
        Arrays.fill(counter, -1);

        for (int[] match : matches) {
            int winner = match[0], loser = match[1];

            if (counter[winner] == -1) {
                counter[winner] = 0;
            }

            if (counter[loser] == -1) {
                counter[loser] = 1;
            } else {
                counter[loser]++;
            }
        }

        for (int i = 0; i < counter.length; i++) {
            if (counter[i] == 0) {
                zeroLoss.add(i);
            } else if (counter[i] == 1) {
                oneLoss.add(i);
            }
        }
        return ans;
    }
}
