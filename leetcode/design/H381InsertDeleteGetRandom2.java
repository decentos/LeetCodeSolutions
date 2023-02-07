package design;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class H381InsertDeleteGetRandom2 {
    private final Map<Integer, Set<Integer>> indexes;
    private final List<Integer> values;
    private final Random random;

    public H381InsertDeleteGetRandom2() {
        indexes = new HashMap<>();
        values = new ArrayList<>();
        random = new Random();
    }

    public boolean insert(int val) {
        indexes.computeIfAbsent(val, v -> new HashSet<>()).add(values.size());
        values.add(val);
        return indexes.get(val).size() == 1;
    }

    public boolean remove(int val) {
        Set<Integer> currIndexes = indexes.get(val);
        if (currIndexes == null || currIndexes.size() == 0) return false;
        int firstIndex = currIndexes.iterator().next();
        currIndexes.remove(firstIndex);

        int lastElement = values.get(values.size() - 1);
        values.set(firstIndex, lastElement);
        Set<Integer> moveIndexes = indexes.get(lastElement);
        moveIndexes.add(firstIndex);
        moveIndexes.remove(values.size() - 1);

        values.remove(values.size() - 1);
        return true;
    }

    public int getRandom() {
        int index = random.nextInt(values.size());
        return values.get(index);
    }
}
