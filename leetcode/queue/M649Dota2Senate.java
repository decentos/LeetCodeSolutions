package queue;

import java.util.ArrayDeque;
import java.util.Deque;

public class M649Dota2Senate {

    public String predictPartyVictory(String senate) {
        Deque<Character> senators = new ArrayDeque<>();

        for (char senator : senate.toCharArray()) {
            senators.offer(senator);
        }

        char party = '-';
        int votes = 0;

        while (!senators.isEmpty()) {
            char curr = senators.poll();

            if (party == '-' || curr == party) {
                party = curr;
                votes++;
                senators.offer(curr);

                if (votes == senators.size()) {
                    return curr == 'R' ? "Radiant" : "Dire";
                }
            } else {
                votes--;
                if (votes == 0) {
                    party = '-';
                }
            }
        }
        return "";
    }
}
