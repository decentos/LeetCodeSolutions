package backtracking;

import java.util.ArrayList;
import java.util.List;

public class E401BinaryWatch {
    private final int[] watch = {1, 2, 4, 8, 1, 2, 4, 8, 16, 32};

    public List<String> readBinaryWatch(int turnedOn) {
        List<String> ans = new ArrayList<>();
        generate(ans, turnedOn, 0, 0, 0);
        return ans;
    }

    private void generate(List<String> ans, int turnedOn, int hours, int minutes, int index) {
        if (hours > 11 || minutes > 59) return;
        if (turnedOn == 0) {
            String minutesFormat = minutes >= 10 ? String.valueOf(minutes) : String.format("0%d", minutes);
            String time = String.format("%d:%s", hours, minutesFormat);
            ans.add(time);
            return;
        }

        for (int i = index; i < watch.length; i++) {
            if (i < 4) generate(ans, turnedOn - 1, hours + watch[i], minutes, i + 1);
            else generate(ans, turnedOn - 1, hours, minutes + watch[i], i + 1);
        }
    }
}
