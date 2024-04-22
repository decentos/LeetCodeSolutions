package queue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class M1291SequentialDigits {

    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> ans = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= 8; i++) {
            queue.offer(i);
        }

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            int add = curr % 10 + 1;
            int seq = curr * 10 + add;
            if (seq >= low && seq <= high) {
                ans.add(seq);
            }
            if (seq % 10 < 9 && seq < high) {
                queue.offer(seq);
            }

        }
        return ans;
    }
}
