package queue;

import java.util.*;

public class H127WordLadder {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        Deque<String> queue = new ArrayDeque<>();
        queue.offer(beginWord);
        int length = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int word = 0; word < size; word++) {
                String curr = queue.poll();

                if (curr.equals(endWord)) {
                    return length;
                }

                for (int letter = 0; letter < curr.length(); letter++) {
                    char[] currArr = curr.toCharArray();

                    for (char c = 'a'; c <= 'z'; c++) {
                        currArr[letter] = c;
                        String nextWord = String.valueOf(currArr);

                        if (wordSet.contains(nextWord)) {
                            wordSet.remove(nextWord);
                            queue.offer(nextWord);
                        }
                    }
                }
            }
            length++;
        }
        return 0;
    }
}
