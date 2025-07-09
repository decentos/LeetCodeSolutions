package uber.algo;

public class M3443MaxManhattanDistance {

    public int maxDistance(String s, int k) {
        int max = 0;
        int south = 0, north = 0, west = 0, east = 0;

        for (char c : s.toCharArray()) {
            switch (c) {
                case 'S' -> south++;
                case 'N' -> north++;
                case 'W' -> west++;
                case 'E' -> east++;
            }

            int timesSouthNorth = Math.min(k, Math.min(south, north));
            int timesWestEast = Math.min(k - timesSouthNorth, Math.min(west, east));

            max = Math.max(max, calculate(south, north, timesSouthNorth) + calculate(west, east, timesWestEast));
        }
        return max;
    }

    private int calculate(int dx1, int dx2, int times) {
        return Math.abs(dx1 - dx2) + times * 2;
    }
}
