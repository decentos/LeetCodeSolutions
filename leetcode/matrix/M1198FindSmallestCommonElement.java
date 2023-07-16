package matrix;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class M1198FindSmallestCommonElement {

    public int smallestCommonElement(int[][] mat) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int[] row : mat) {
            for (int col : row) {
                map.merge(col, 1, Integer::sum);
            }
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == mat.length) return entry.getKey();
        }
        return -1;
    }

    public int smallestCommonElement2(int[][] mat) {
        Set<Integer> set = Arrays.stream(mat[0]).boxed().collect(Collectors.toSet());

        for (int i = 1; i < mat.length; i++) {
            Set<Integer> temp = Arrays.stream(mat[i]).boxed().collect(Collectors.toSet());
            set.retainAll(temp);
        }

        return set.isEmpty() ? -1 : set.iterator().next();
    }
}
