package graph;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class M841KeysRooms {

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] openedRooms = new boolean[rooms.size()];
        Deque<Integer> keys = new ArrayDeque<>();
        keys.offer(0);

        while (!keys.isEmpty()) {
            int key = keys.poll();
            openedRooms[key] = true;
            for (int nextKey : rooms.get(key)) {
                if (!openedRooms[nextKey]) {
                    keys.offer(nextKey);
                }
            }
        }

        for (boolean openedRoom : openedRooms) {
            if (!openedRoom) {
                return false;
            }
        }
        return true;
    }
}
