package easy;

import java.util.HashMap;
import java.util.Map;

public class E169MajorityElement {

    // Boyer-Moore Voting Algorithm
    public int majorityElement(int[] nums) {
        int candidate = 0, freq = 0;

        for (int num : nums) {
            if (freq == 0) {
                candidate = num;
            }

            if (candidate == num) {
                freq++;
            } else {
                freq--;
            }
        }
        return candidate;
    }
}
