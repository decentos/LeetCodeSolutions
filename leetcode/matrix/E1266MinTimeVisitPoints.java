package matrix;

public class E1266MinTimeVisitPoints {

    public int minTimeToVisitAllPoints(int[][] points) {
        int time = 0;

        for (int i = 0; i < points.length - 1; i++) {
            int currX = points[i][0];
            int currY = points[i][1];
            int nextX = points[i + 1][0];
            int nextY = points[i + 1][1];
            time += Math.max(Math.abs(currX - nextX), Math.abs(currY - nextY));
        }
        return time;
    }
}
