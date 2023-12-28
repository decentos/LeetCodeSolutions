package medium;

public class M1578MinTimeToColorful {

    public int minCost(String colors, int[] neededTime) {
        int time = 0, currMax = neededTime[0];

        for (int i = 1; i < colors.length(); i++) {
            if (colors.charAt(i) != colors.charAt(i - 1)) {
                currMax = 0;
            }

            time += Math.min(currMax, neededTime[i]);
            currMax = Math.max(currMax, neededTime[i]);
        }
        return time;
    }
}
