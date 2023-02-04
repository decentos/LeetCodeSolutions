package easy;

import java.util.HashSet;
import java.util.Set;

public class E136SingleNumber {

    public int singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            if (set.contains(i)) {
                set.remove(i);
            } else {
                set.add(i);
            }
        }
        return set.stream().findAny().orElse(-1);
    }

}
