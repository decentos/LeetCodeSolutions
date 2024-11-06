package uber.algo;

import java.util.ArrayList;
import java.util.List;

public class M986IntervalListIntersections {

    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> intersections = new ArrayList<>();
        int m = firstList.length, n = secondList.length;
        int firstIndex = 0, secondIndex = 0;

        while (firstIndex < m && secondIndex < n) {
            int[] firstCurr = firstList[firstIndex];
            int[] secondCurr = secondList[secondIndex];

            if (firstCurr[0] > secondCurr[1]) {
                secondIndex++;
            } else if (secondCurr[0] > firstCurr[1]) {
                firstIndex++;
            } else {
                int startIntersection = Math.max(firstCurr[0], secondCurr[0]);
                int endIntersection = Math.min(firstCurr[1], secondCurr[1]);
                intersections.add(new int[]{startIntersection, endIntersection});

                if (firstCurr[1] > secondCurr[1]) {
                    secondIndex++;
                } else {
                    firstIndex++;
                }
            }
        }

        return intersections.toArray(new int[intersections.size()][]);
    }
}
