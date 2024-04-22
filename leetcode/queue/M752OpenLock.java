package queue;

import java.util.*;

public class M752OpenLock {

    public int openLock(String[] deadends, String target) {
        String start = "0000";
        Set<String> visited = new HashSet<>(Arrays.asList(deadends));
        if (visited.contains(start)) {
            return -1;
        }
        visited.add(start);
        Deque<String> queue = new ArrayDeque<>();
        queue.offer(start);
        int count = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                String curr = queue.poll();

                if (curr.equals(target)) {
                    return count;
                }

                for (int j = 0; j < 4; j++) {
                    char[] nextChars = curr.toCharArray();
                    nextChars[j] = nextChars[j] == '9' ? '0' : ++nextChars[j];
                    String next = String.valueOf(nextChars);
                    if (!visited.contains(next)) {
                        visited.add(next);
                        queue.offer(next);
                    }

                    char[] prevChars = curr.toCharArray();
                    prevChars[j] = prevChars[j] == '0' ? '9' : --prevChars[j];
                    String prev = String.valueOf(prevChars);
                    if (!visited.contains(prev)) {
                        visited.add(prev);
                        queue.offer(prev);
                    }
                }
            }
            count++;
        }
        return -1;
    }
}
