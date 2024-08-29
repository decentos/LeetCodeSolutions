package string;

import java.util.Set;

public class E345ReverseVowelsString {

    public String reverseVowels(String s) {
        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');
        char[] reversed = s.toCharArray();
        int left = 0, right = s.length() - 1;

        while (left < right) {
            while (left < right && !vowels.contains(s.charAt(left))) {
                left++;
            }
            while (left < right && !vowels.contains(s.charAt(right))) {
                right--;
            }

            char temp = reversed[left];
            reversed[left] = reversed[right];
            reversed[right] = temp;

            left++;
            right--;
        }
        return new String(reversed);
    }
}
