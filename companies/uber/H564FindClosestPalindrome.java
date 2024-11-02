package uber;

import java.util.ArrayList;
import java.util.List;

public class H564FindClosestPalindrome {

    public String nearestPalindromic(String n) {
        int len = n.length(), halfLen = len % 2 == 0 ? len / 2 - 1 : len / 2;
        long leftHalf = Long.parseLong(n.substring(0, halfLen + 1));

        List<Long> palindromes = new ArrayList<>();
        palindromes.add(createPalindrome(leftHalf, len % 2 == 1));
        palindromes.add(createPalindrome(leftHalf - 1, len % 2 == 1));
        palindromes.add(createPalindrome(leftHalf + 1, len % 2 == 1));
        palindromes.add((long) Math.pow(10, len - 1) - 1);
        palindromes.add((long) Math.pow(10, len) + 1);

        long minDiff = Long.MAX_VALUE, closest = Long.MAX_VALUE, original = Long.parseLong(n);
        for (long palindrome : palindromes) {
            if (palindrome == original) {
                continue;
            }

            long currDiff = Math.abs(original - palindrome);
            if (currDiff < minDiff) {
                minDiff = currDiff;
                closest = palindrome;
            } else if (currDiff == minDiff) {
                closest = Math.min(closest, palindrome);
            }
        }

        return String.valueOf(closest);
    }

    private long createPalindrome(long leftHalf, boolean isOdd) {
        long palindrome = leftHalf;

        if (isOdd) {
            leftHalf /= 10;
        }

        while (leftHalf > 0) {
            palindrome = palindrome * 10 + (leftHalf % 10);
            leftHalf /= 10;
        }
        return palindrome;
    }
}
