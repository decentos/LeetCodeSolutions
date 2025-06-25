package uber.design;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class M1429FirstUniqueNumber {
    private Map<Integer, Integer> map;
    private Deque<Integer> seq;

    public M1429FirstUniqueNumber(int[] nums) {
        map = new HashMap<>();
        seq = new ArrayDeque<>();

        for (int num : nums) {
            this.add(num);
        }
    }

    public int showFirstUnique() {
        while (!seq.isEmpty() && map.get(seq.peek()) > 1) {
            seq.poll();
        }
        return seq.isEmpty() ? -1 : seq.peek();
    }

    public void add(int value) {
        map.merge(value, 1, Integer::sum);
        seq.offer(value);
    }
}
