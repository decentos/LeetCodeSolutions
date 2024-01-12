package string;

import java.util.Set;

public class E1704StringAlike {

    public boolean halvesAreAlike(String s) {
        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');
        int leftCount = 0, rightCount = 0;
        int n = s.length();

        for (int i = 0; i < n / 2; i++) {
            if (vowels.contains(s.charAt(i))) {
                leftCount++;
            }
        }
        for (int i = n / 2; i < n; i++) {
            if (vowels.contains(s.charAt(i))) {
                rightCount++;
            }
        }
        return leftCount == rightCount;
    }
}
