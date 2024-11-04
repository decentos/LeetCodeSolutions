package uber;

import java.util.*;

public class H269AlienDictionary {

    public String alienOrder(String[] words) {
        StringBuilder order = new StringBuilder();
        Map<Integer, List<Integer>> adj = new HashMap<>();
        int uniqueLetters = 0;
        int[] inDegree = new int[26];
        Arrays.fill(inDegree, -1);

        for (String word : words) {
            for (char letter : word.toCharArray()) {
                if (inDegree[letter - 'a'] == -1) {
                    inDegree[letter - 'a'] = 0;
                    uniqueLetters++;
                }
            }
        }

        for (int i = 1; i < words.length; i++) {
            String prev = words[i - 1];
            String curr = words[i];
            int nPrev = prev.length(), nCurr = curr.length(), index = 0;

            while (index < nPrev && index < nCurr && prev.charAt(index) == curr.charAt(index)) {
                index++;
            }

            if (nPrev > nCurr && index == nCurr) {
                return "";
            } else if (index == nPrev) {
                continue;
            }

            int prevIndex = prev.charAt(index) - 'a';
            int currIndex = curr.charAt(index) - 'a';
            inDegree[currIndex]++;
            adj.computeIfAbsent(prevIndex, val -> new ArrayList<>()).add(currIndex);
        }

        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int currIndex = queue.poll();
            char currChar = (char) (currIndex + 'a');
            order.append(currChar);

            if (adj.containsKey(currIndex)) {
                List<Integer> neighbors = adj.get(currIndex);
                for (int neighbor : neighbors) {
                    inDegree[neighbor]--;
                    if (inDegree[neighbor] == 0) {
                        queue.offer(neighbor);
                    }
                }
            }
        }
        return order.length() == uniqueLetters ? order.toString() : "";
    }
}
