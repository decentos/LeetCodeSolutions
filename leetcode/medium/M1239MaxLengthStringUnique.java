package medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class M1239MaxLengthStringUnique {

    public int maxLength(List<String> arr) {
        int max = 0;
        List<String> unique = new ArrayList<>();
        unique.add("");

        for (String part : arr) {
            int size = unique.size();
            for (int i = 0; i < size; i++) {
                String concat = unique.get(i) + part;
                Set<Character> set = new HashSet<>();
                for (char c : concat.toCharArray()) {
                    set.add(c);
                }

                if (set.size() == concat.length()) {
                    unique.add(concat);
                    max = Math.max(max, concat.length());
                }
            }
        }
        return max;
    }
}
