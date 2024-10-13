package greedy.kadane;

public class M134GasStation {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalSum = 0, currSum = 0, startIndex = 0;

        for (int i = 0; i < gas.length; i++) {
            totalSum += gas[i] - cost[i];
            currSum += gas[i] - cost[i];
            if (currSum < 0) {
                currSum = 0;
                startIndex = i + 1;
            }
        }
        return totalSum >= 0 ? startIndex : -1;
    }
}
