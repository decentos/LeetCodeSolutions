package hash;

import java.util.HashSet;
import java.util.Set;

public class E1426CountingElements {

    public int countElements(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for (int i : arr) set.add(i);

        int count = 0;
        for (int i : arr) {
            if (set.contains(i + 1)) {
                count++;
            }
        }
        return count;
    }
}
