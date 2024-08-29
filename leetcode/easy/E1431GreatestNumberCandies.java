package easy;

import java.util.ArrayList;
import java.util.List;

public class E1431GreatestNumberCandies {

    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> greatest = new ArrayList<>();
        int max = 0;
        for (int count : candies) {
            max = Math.max(max, count);
        }

        for (int count : candies) {
            greatest.add(count + extraCandies >= max);
        }
        return greatest;
    }
}
