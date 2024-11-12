package hash;

import java.util.HashSet;
import java.util.Set;

public class E202HappyNumber {

    public boolean isHappy(int n) {
        Set<Integer> visited = new HashSet<>();

        while (n != 1 && !visited.contains(n)) {
            visited.add(n);
            int sum = 0;
            while (n > 0) {
                int digit = n % 10;
                n /= 10;
                sum += digit * digit;
            }
            n = sum;
        }

        return n == 1;
    }
}
