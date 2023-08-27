package string;

import java.util.Set;

public class E1119RemoveVowelsString {

    public String removeVowels(String s) {
        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');
        StringBuilder result = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (vowels.contains(c)) continue;
            result.append(c);
        }
        return result.toString();
    }

    public String removeVowels2(String s) {
        return s.replaceAll("[aeiou]", "");
    }
}
