package design;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class M380InsertDeleteGetRandom {
    private final List<Integer> values;
    private final Map<Integer, Integer> indexes;
    private final Random random;

    public M380InsertDeleteGetRandom() {
        values = new ArrayList<>();
        indexes = new HashMap<>();
        random = new Random();
    }

    public boolean insert(int val) {
        if (indexes.containsKey(val)) return false;
        indexes.put(val, values.size());
        values.add(val);
        return true;
    }

    public boolean remove(int val) {
        Integer index = indexes.get(val);
        if (index == null) return false;
        int last = values.get(values.size() - 1);
        values.set(index, last);
        indexes.replace(last, index);
        values.remove(values.size() - 1);
        indexes.remove(val);
        return true;
    }

    public int getRandom() {
        int index = random.nextInt(values.size());
        return values.get(index);
    }
}
