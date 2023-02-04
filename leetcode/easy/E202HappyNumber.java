package easy;

import java.util.HashSet;
import java.util.Set;

public class E202HappyNumber {

    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while (n != 1) {
            int sumOfSquare = 0;
            while (n > 0) {
                int lastDigit = n % 10;
                sumOfSquare += lastDigit * lastDigit;
                n /= 10;
            }
            if (sumOfSquare < 0 || set.contains(sumOfSquare)) return false;
            set.add(sumOfSquare);
            n = sumOfSquare;
        }
        return true;
    }
}
