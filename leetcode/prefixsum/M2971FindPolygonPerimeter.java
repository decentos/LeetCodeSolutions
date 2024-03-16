package prefixsum;

import java.util.Arrays;

public class M2971FindPolygonPerimeter {

    public long largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        long sum = 0, perimeter = -1;

        for (int num : nums) {
            if (sum > num) {
                perimeter = sum + num;
            }
            sum += num;
        }
        return perimeter;
    }
}
