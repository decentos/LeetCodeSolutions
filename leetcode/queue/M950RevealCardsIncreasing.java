package queue;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class M950RevealCardsIncreasing {

    public int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);
        int n = deck.length;
        int[] order = new int[n];
        int orderIndex = 0;
        Deque<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            queue.offer(i);
        }

        while (!queue.isEmpty()) {
            int top = queue.poll();
            order[top] = deck[orderIndex++];

            if (!queue.isEmpty()) {
                int bottom = queue.poll();
                queue.offer(bottom);
            }
        }
        return order;
    }
}
