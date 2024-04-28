package medium;

import java.util.HashSet;
import java.util.Set;

public class M2521DistinctPrimeFactors {

    public int distinctPrimeFactors(int[] nums) {
        Set<Integer> factors = new HashSet<>();
        for (int num : nums) {
            addFactors(num, factors);
        }
        return factors.size();
    }

    private void addFactors(int num, Set<Integer> factors) {
        if (num % 2 == 0) {
            factors.add(2);
            while (num % 2 == 0) {
                num /= 2;
            }
        }

        for (int i = 3; i <= Math.sqrt(num); i += 2) {
            if (num % i == 0) {
                factors.add(i);
                while (num % i == 0) {
                    num /= i;
                }
            }
        }

        if (num > 2) {
            factors.add(num);
        }
    }
}
