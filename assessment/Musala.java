import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Musala {
    public static void main(String[] args) {
        System.out.println(compressedString("abaabbbc"));
        System.out.println(countSentences(List.of("the", "bats", "tabs", "in", "cat", "act"), List.of("cat the bats", "in the act", "act tabs in")));
        System.out.println(palindrome("abbc"));
    }

    public static String compressedString(String message) {
        if (message == null || message.length() < 2) return message;

        char[] chars = message.toCharArray();
        StringBuilder result = new StringBuilder();

        int count = 1;
        int i = 0;
        while (i < chars.length) {
            while (i < chars.length - 1 && chars[i] == chars[i + 1]) {
                count++;
                i++;
            }
            result.append(chars[i]);
            if (count > 1) {
                result.append(count);
                count = 1;
            }
            i++;
        }
        return result.toString();
    }

    public static int palindrome(String s) {
        Set<String> set = new HashSet<>();
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                set.add(s.substring(i, j));
            }
        }
        for (String str : set) {
            count += isPalindrome(str) ? 1 : 0;
        }
        return count;
    }

    private static boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static List<Long> countSentences(List<String> wordSet, List<String> sentences) {
        List<Long> count = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        Map<String, List<String>> mapToUse = new HashMap<>();

        for (String word : wordSet) {
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String sorted = String.valueOf(chars);

            List<String> list = map.get(sorted) != null ? map.get(sorted) : new ArrayList<>();
            list.add(word);
            map.put(sorted, list);
            mapToUse.put(word, list);

        }
        for (String sentence : sentences) {
            long sum;
            String[] arr = sentence.trim().split(" ");
            sum = Arrays.stream(arr)
                    .filter(str -> mapToUse.get(str) != null)
                    .map(mapToUse::get)
                    .mapToLong(List::size)
                    .reduce(1, (a, b) -> a * b);
            count.add(sum);
        }
        return count;
    }
}
