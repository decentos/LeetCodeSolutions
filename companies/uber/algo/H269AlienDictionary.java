package uber.algo;

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
            int prevLen = prev.length(), currLen = curr.length(), index = 0;

            while (index < prevLen && index < currLen && prev.charAt(index) == curr.charAt(index)) {
                index++;
            }

            if (prevLen > currLen && index == currLen) {
                return "";
            } else if (index == prevLen) {
                continue;
            }

            int prevLetter = prev.charAt(index) - 'a';
            int currLetter = curr.charAt(index) - 'a';
            inDegree[currLetter]++;
            adj.computeIfAbsent(prevLetter, val -> new ArrayList<>()).add(currLetter);
        }

        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            char letter = (char) (curr + 'a');
            order.append(letter);

            if (adj.containsKey(curr)) {
                List<Integer> neighbors = adj.get(curr);
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
