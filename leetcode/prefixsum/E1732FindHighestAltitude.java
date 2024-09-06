package prefixsum;

public class E1732FindHighestAltitude {

    public int largestAltitude(int[] gain) {
        int max = 0, sum = 0;

        for (int curr : gain) {
            sum += curr;
            max = Math.max(max, sum);
        }
        return max;
    }
}
