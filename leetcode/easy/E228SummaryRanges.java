package easy;

import java.util.ArrayList;
import java.util.List;

public class E228SummaryRanges {

    public List<String> summaryRanges(int[] nums) {
        int n = nums.length;
        List<String> ranges = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int startRange = nums[i];
            int endRange = startRange;

            while (i + 1 < n && nums[i + 1] - endRange == 1) {
                endRange++;
                i++;
            }

            if (startRange == endRange) {
                ranges.add(String.valueOf(startRange));
            } else {
                ranges.add(startRange + "->" + endRange);
            }
        }
        return ranges;
    }
}
