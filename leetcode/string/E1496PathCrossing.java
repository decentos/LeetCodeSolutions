package string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class E1496PathCrossing {

    public boolean isPathCrossing(String path) {
        Map<Character, int[]> dirs = Map.of(
                'N', new int[]{1, 0},
                'S', new int[]{-1, 0},
                'E', new int[]{0, 1},
                'W', new int[]{0, -1}
        );
        Map<Integer, Set<Integer>> points = new HashMap<>();
        int currX = 0, currY = 0;

        for (char c : path.toCharArray()) {
            points.computeIfAbsent(currX, val -> new HashSet<>()).add(currY);

            int[] dir = dirs.get(c);
            currX += dir[0];
            currY += dir[1];

            if (points.containsKey(currX) && points.get(currX).contains(currY)) {
                return true;
            }
        }
        return false;
    }
}
