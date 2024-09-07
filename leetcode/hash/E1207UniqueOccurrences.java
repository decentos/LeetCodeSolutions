package hash;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class E1207UniqueOccurrences {

    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> occurrences = new HashMap<>();
        Set<Integer> unique = new HashSet<>();

        for (int num : arr) {
            occurrences.merge(num, 1, Integer::sum);
        }

        for (int count : occurrences.values()) {
            if (unique.contains(count)) {
                return false;
            }
            unique.add(count);
        }
        return true;
    }
}
