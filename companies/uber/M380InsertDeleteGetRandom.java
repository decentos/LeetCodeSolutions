package uber;

import java.util.*;

public class M380InsertDeleteGetRandom {
    private final Map<Integer, Integer> map;
    private final List<Integer> list;
    private final Random random;

    public M380InsertDeleteGetRandom() {
        map = new HashMap<>();
        list = new ArrayList<>();
        random = new Random();
    }

    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }
        map.put(val, list.size());
        list.add(val);
        return true;
    }

    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }
        int removeIndex = map.get(val);
        int lastElement = list.getLast();
        list.set(removeIndex, lastElement);
        map.replace(lastElement, removeIndex);
        list.removeLast();
        map.remove(val);
        return true;
    }

    public int getRandom() {
        int index = random.nextInt(list.size());
        return list.get(index);
    }
}
