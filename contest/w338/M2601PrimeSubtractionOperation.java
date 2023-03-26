package w338;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class M2601PrimeSubtractionOperation {

    public boolean primeSubOperation(int[] nums) {
        int max = 0;
        for (int num : nums) max = Math.max(max, num);
        List<Integer> primes = findPrimes(max);

        for (int i = nums.length - 1; i > 0; i--) {
            int curr = nums[i];
            int prev = nums[i - 1];
            if (prev >= curr) {
                boolean isLess = false;

                for (int prime : primes) {
                    if (prime >= prev) break;

                    if (curr > prev - prime) {
                        nums[i - 1] = prev - prime;
                        isLess = true;
                        break;
                    }
                }
                if (!isLess) return false;
            }
        }
        return true;
    }

    private List<Integer> findPrimes(int count) {
        boolean[] isPrime = new boolean[count + 1];
        Arrays.fill(isPrime, true);
        for (int i = 2; i * i <= count; i++) {
            if (isPrime[i]) {
                for (int j = i * 2; j <= count; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        List<Integer> primes = new LinkedList<>();
        for (int i = 2; i <= count; i++) {
            if (isPrime[i]) {
                primes.add(i);
            }
        }
        return primes;
    }
}
