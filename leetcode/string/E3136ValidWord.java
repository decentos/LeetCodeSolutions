package string;

import java.util.Set;

public class E3136ValidWord {

    public boolean isValid(String word) {
        if (word.length() < 3) {
            return false;
        }
        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');
        boolean hasVowels = false, hasConsonant = false;

        for (char c : word.toCharArray()) {
            if (Character.isLetter(c)) {
                if (vowels.contains(c)) {
                    hasVowels = true;
                } else {
                    hasConsonant = true;
                }
            } else if (!Character.isDigit(c)) {
                return false;
            }
        }
        return hasVowels && hasConsonant;
    }
}
