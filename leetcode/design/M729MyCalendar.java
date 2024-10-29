package design;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class M729MyCalendar {

    private static class MyCalendar {
        private final TreeMap<Integer, Integer> events;

        public MyCalendar() {
            events = new TreeMap<>();
        }

        public boolean book(int startTime, int endTime) {
            Map.Entry<Integer, Integer> prev = events.floorEntry(startTime);
            Integer nextStartTime = events.ceilingKey(startTime);

            if (prev != null && prev.getValue() > startTime || nextStartTime != null && endTime > nextStartTime) {
                return false;
            }

            events.put(startTime, endTime);
            return true;
        }
    }

// ===============================================================================

    private static class MyCalendar2 {
        private final List<int[]> events;

        public MyCalendar2() {
            events = new ArrayList<>();
        }

        public boolean book(int startTime, int endTime) {
            if (events.isEmpty() || events.getFirst()[0] >= endTime) {
                events.add(0, new int[]{startTime, endTime});
                return true;
            } else if (events.getLast()[1] <= startTime) {
                events.add(new int[]{startTime, endTime});
                return true;
            }

            int left = 1, right = events.size() - 1;

            while (left <= right) {
                int mid = (left + right) / 2;
                int[] curr = events.get(mid);
                int[] prev = events.get(mid - 1);

                if (prev[1] <= startTime && curr[0] >= endTime) {
                    events.add(mid, new int[]{startTime, endTime});
                    return true;
                } else if (prev[1] > startTime && startTime >= prev[0] || curr[1] > endTime && endTime >= curr[0]) {
                    return false;
                } else if (endTime <= curr[0]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }

            return false;
        }
    }
}
