package easy;

import java.util.HashSet;
import java.util.Set;

public class E771JewelsStones {

    public int numJewelsInStones(String jewels, String stones) {
        int count = 0;
        Set<Character> set = new HashSet<>();
        for (char c : jewels.toCharArray()) set.add(c);
        for (char c : stones.toCharArray()) {
            if (set.contains(c)) count++;
        }
        return count;
    }
}
