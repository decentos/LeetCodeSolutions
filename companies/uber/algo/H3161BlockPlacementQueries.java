package uber.algo;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class H3161BlockPlacementQueries {

    public List<Boolean> getResults(int[][] queries) {
        List<Boolean> results = new ArrayList<>();
        TreeMap<Integer, Integer> obstacles = new TreeMap<>();

        for (int[] query : queries) {
            if (query[0] == 1) {
                int index = query[1];
                Integer prev = obstacles.lowerKey(index);
                Integer next = obstacles.higherKey(index);

                if (prev == null) {
                    obstacles.put(index, index);
                } else {
                    obstacles.put(index, Math.max(index - prev, obstacles.get(prev)));
                }

                prev = index;
                while (next != null && obstacles.get(next) > obstacles.get(prev)) {
                    obstacles.put(next, Math.max(next - prev, obstacles.get(prev)));
                    prev = next;
                    next = obstacles.higherKey(next);
                }
            } else {
                int index = query[1], size = query[2];

                if (obstacles.containsKey(index)) {
                    results.add(obstacles.get(index) >= size);
                } else {
                    Integer prev = obstacles.lowerKey(index);
                    if (prev == null) {
                        results.add(index >= size);
                    } else {
                        results.add(Math.max(index - prev, obstacles.get(prev)) >= size);
                    }
                }
            }
        }
        return results;
    }
}
