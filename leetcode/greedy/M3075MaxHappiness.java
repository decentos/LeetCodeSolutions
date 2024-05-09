package greedy;

import java.util.Arrays;

public class M3075MaxHappiness {

    public long maximumHappinessSum(int[] happiness, int k) {
        int index = happiness.length - 1;
        long sum = 0;
        Arrays.sort(happiness);

        for (int turn = 0; turn < k; turn++) {
            if (turn >= happiness[index]) {
                break;
            }
            sum += happiness[index--] - turn;
        }
        return sum;
    }
}
