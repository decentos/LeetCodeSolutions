package design;

import java.util.TreeSet;

public class M2336SmallestNumber {
    private final TreeSet<Integer> set;
    private int current;

    public M2336SmallestNumber() {
        set = new TreeSet<>();
        current = 1;
    }

    public int popSmallest() {
        int smallest;
        if (set.isEmpty()) {
            smallest = current;
            current++;
        } else {
            smallest = set.first();
            set.remove(smallest);
        }
        return smallest;
    }

    public void addBack(int num) {
        if (num >= current || set.contains(num)) return;
        set.add(num);
    }
}
