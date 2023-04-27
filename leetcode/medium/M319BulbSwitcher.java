package medium;

import java.util.Arrays;

public class M319BulbSwitcher {

    public int bulbSwitch(int n) {
        return (int) Math.sqrt(n);
    }

    // Brute force (TLE)
    public int bulbSwitch2(int n) {
        boolean[] states = new boolean[n];
        Arrays.fill(states, true);

        for (int i = 2; i <= n; i++) {
            for (int j = i - 1; j < n; j += i) {
                states[j] = !states[j];
            }
        }

        int count = 0;
        for (boolean on : states) {
            if (on) count++;
        }
        return count;
    }
}
