package string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class E266PalindromePermutation {

    public boolean canPermutePalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) map.merge(c, 1, Integer::sum);
        int count = 0;
        for (int val : map.values()) count += val % 2;
        return count <= 1;
    }

    public boolean canPermutePalindrome2(String s) {
        Set<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            if (set.contains(c)) set.remove(c);
            else set.add(c);
        }
        return set.size() <= 1;
    }
}
