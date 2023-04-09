package w340;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class M2615SumDistances {

    public long[] distance(int[] nums) {
        int n = nums.length;
        long[] arr = new long[n];

        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(nums[i], val -> new ArrayList<>()).add(i);
        }

        for (List<Integer> indexes : map.values()) {
            int size = indexes.size();
            if (size > 1) {
                long nextSum = indexes.stream().mapToLong(i -> i).sum();
                long prevSum = 0;

                for (int i = 0; i < size; i++) {
                    int index = indexes.get(i);
                    long temp = nextSum - ((long) (size - i) * index);
                    temp += Math.abs(prevSum - (long) i * index);

                    arr[index] = temp;
                    nextSum -= index;
                    prevSum += index;
                }
            }
        }
        return arr;
    }
}
