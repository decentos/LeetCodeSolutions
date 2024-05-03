package graph.topologicalsort;

import java.util.*;

public class H269AlienDictionary {

    public String alienOrder(String[] words) {
        StringBuilder order = new StringBuilder();
        Deque<Integer> queue = new ArrayDeque<>();
        Map<Integer, List<Integer>> adj = new HashMap<>();
        int uniqueLetters = 0;
        int[] inDegree = new int[26];
        Arrays.fill(inDegree, -1);

        for (String word : words) {
            for (char c : word.toCharArray()) {
                if (inDegree[c - 'a'] == -1) {
                    inDegree[c - 'a'] = 0;
                    uniqueLetters++;
                }
            }
        }

        for (int i = 1; i < words.length; i++) {
            String prev = words[i - 1];
            String curr = words[i];
            int n1 = prev.length(), n2 = curr.length(), index = 0;

            while (index < n1 && index < n2 && prev.charAt(index) == curr.charAt(index)) {
                index++;
            }

            if (n1 > n2 && index >= n2) {
                return "";
            } else if (index >= n1) {
                continue;
            }

            int prevIndex = prev.charAt(index) - 'a';
            int currIndex = curr.charAt(index) - 'a';
            inDegree[currIndex]++;
            adj.computeIfAbsent(prevIndex, val -> new ArrayList<>()).add(currIndex);
        }

        for (int i = 0; i < 26; i++) {
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
                        queue.add(neighbor);
                    }
                }
            }
        }
        return order.length() == uniqueLetters ? order.toString() : "";
    }
}
