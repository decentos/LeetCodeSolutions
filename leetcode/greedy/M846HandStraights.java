package greedy;

import java.util.TreeMap;

public class M846HandStraights {

    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) {
            return false;
        }

        TreeMap<Integer, Integer> counter = new TreeMap<>();

        for (int h : hand) {
            counter.merge(h, 1, Integer::sum);
        }

        while (!counter.isEmpty()) {
            int lowest = counter.firstKey();
            if (counter.get(lowest) == 1) {
                counter.remove(lowest);
            } else {
                counter.merge(lowest, -1, Integer::sum);
            }

            for (int next = 1; next < groupSize; next++) {
                if (!counter.containsKey(lowest + next)) {
                    return false;
                } else if (counter.get(lowest + next) == 1) {
                    counter.remove(lowest + next);
                } else {
                    counter.merge(lowest + next, -1, Integer::sum);
                }
            }
        }
        return true;
    }
}
