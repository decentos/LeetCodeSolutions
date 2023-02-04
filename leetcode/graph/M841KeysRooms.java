package graph;

import java.util.List;
import java.util.Stack;

public class M841KeysRooms {

    public static boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] seen = new boolean[rooms.size()];
        seen[0] = true;
        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        while (!stack.empty()) {
            int roomId = stack.pop();
            List<Integer> room = rooms.get(roomId);
            for (int key : room) {
                if (!seen[key]) {
                    seen[key] = true;
                    stack.push(key);
                }
            }
        }
        for (boolean open : seen) {
            if (!open) return false;
        }
        return true;
    }
}
