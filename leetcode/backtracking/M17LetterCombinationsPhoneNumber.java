package backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class M17LetterCombinationsPhoneNumber {
    private final Map<Character, List<Character>> map = new HashMap<>();

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) return Collections.emptyList();

        List<String> ans = new ArrayList<>();
        fillMap(map);
        generate(ans, new StringBuilder(), digits, 0);
        return ans;
    }

    private void generate(List<String> ans, StringBuilder curr, String digits, int index) {
        if (index == digits.length()) {
            ans.add(curr.toString());
            return;
        }

        List<Character> letters = map.get(digits.charAt(index));
        for (Character letter : letters) {
            curr.append(letter);
            generate(ans, curr, digits, index + 1);
            curr.deleteCharAt(curr.length() - 1);
        }
    }

    private void fillMap(Map<Character, List<Character>> map) {
        map.put('2', List.of('a', 'b', 'c'));
        map.put('3', List.of('d', 'e', 'f'));
        map.put('4', List.of('g', 'h', 'i'));
        map.put('5', List.of('j', 'k', 'l'));
        map.put('6', List.of('m', 'n', 'o'));
        map.put('7', List.of('p', 'q', 'r', 's'));
        map.put('8', List.of('t', 'u', 'v'));
        map.put('9', List.of('w', 'x', 'y', 'z'));
    }
}
