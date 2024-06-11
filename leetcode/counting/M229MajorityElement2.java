package counting;

import java.util.ArrayList;
import java.util.List;

public class M229MajorityElement2 {

    // Boyer-Moore Voting Algorithm
    public List<Integer> majorityElement(int[] nums) {
        int candidate1 = 0, freq1 = 0;
        int candidate2 = 0, freq2 = 0;

        for (int num : nums) {
            if (candidate1 == num) {
                freq1++;
            } else if (candidate2 == num) {
                freq2++;
            } else if (freq1 == 0) {
                candidate1 = num;
                freq1++;
            } else if (freq2 == 0) {
                candidate2 = num;
                freq2++;
            } else {
                freq1--;
                freq2--;
            }
        }

        freq1 = 0;
        freq2 = 0;
        for (int num : nums) {
            if (num == candidate1) freq1++;
            else if (num == candidate2) freq2++;
        }

        List<Integer> result = new ArrayList<>();
        if (freq1 > nums.length / 3) result.add(candidate1);
        if (freq2 > nums.length / 3) result.add(candidate2);
        return result;
    }
}
