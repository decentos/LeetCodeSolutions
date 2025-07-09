package queue;

import java.util.*;

public class M433MinGeneticMutation {

    public int minMutation(String startGene, String endGene, String[] bank) {
        char[] genes = {'A', 'C', 'G', 'T'};
        Set<String> bankSet = new HashSet<>(Arrays.asList(bank));
        Deque<String> queue = new ArrayDeque<>();
        queue.offer(startGene);
        int steps = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int word = 0; word < size; word++) {
                String curr = queue.poll();

                if (curr.equals(endGene)) {
                    return steps;
                }

                for (int letter = 0; letter < curr.length(); letter++) {
                    char[] currArr = curr.toCharArray();

                    for (char gene : genes) {
                        currArr[letter] = gene;
                        String newGene = String.valueOf(currArr);
                        if (bankSet.contains(newGene)) {
                            bankSet.remove(newGene);
                            queue.offer(newGene);
                        }
                    }
                }
            }
            steps++;
        }
        return -1;
    }
}
