package easy;

import java.util.ArrayList;
import java.util.List;

public class E448FindDisappearedArray {

    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int[] counter = new int[nums.length + 1];
        for (int i : nums) counter[i]++;
        for (int i = 1; i <= nums.length; i++) {
            if (counter[i] == 0) result.add(i);
        }
        return result;
    }

    public List<Integer> findDisappearedNumbers2(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int index = 0;
        while (index < nums.length) {
            while (nums[index] != index + 1 && nums[index] != nums[nums[index] - 1]) {
                int curr = nums[index];
                int pos = nums[curr - 1];
                nums[index] = pos;
                nums[curr - 1] = curr;
            }
            index++;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) result.add(i + 1);
        }
        return result;
    }

    public List<Integer> findDisappearedNumbers3(int[] nums) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] > 0) {
                nums[index] *= -1;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) result.add(i + 1);
        }
        return result;
    }
}
