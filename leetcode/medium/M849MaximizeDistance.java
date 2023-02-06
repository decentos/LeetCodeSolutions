package medium;

public class M849MaximizeDistance {

    public int maxDistToClosest(int[] seats) {
        int currMax = 0, maxDist = 0, n = seats.length;

        for (int i : seats) {
            if (i == 0) {
                currMax++;
            } else {
                maxDist = Math.max(maxDist, (currMax + 1) / 2);
                currMax = 0;
            }
        }

        for (int i = 0; i < n; i++) {
            if (seats[i] == 1) {
                maxDist = Math.max(maxDist, i);
                break;
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            if (seats[i] == 1) {
                maxDist = Math.max(maxDist, n - 1 - i);
                break;
            }
        }
        return maxDist;
    }
}
