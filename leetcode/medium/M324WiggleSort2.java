package medium;

import java.util.Arrays;

public class M324WiggleSort2 {

    public void wiggleSort(int[] nums) {
        int n = nums.length;
        int[] copy = nums.clone();
        Arrays.sort(copy);
        int pointer = n - 1;

        for (int i = 1; i < n; i += 2) nums[i] = copy[pointer--];
        for (int i = 0; i < n; i += 2) nums[i] = copy[pointer--];
    }
}
