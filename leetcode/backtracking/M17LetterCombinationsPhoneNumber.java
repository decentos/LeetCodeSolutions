package backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class M17LetterCombinationsPhoneNumber {
    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) {
            return Collections.emptyList();
        }
        List<String> combinations = new ArrayList<>();
        backtrack(digits, combinations, new StringBuilder(), 0);
        return combinations;
    }

    private void backtrack(String digits, List<String> combinations, StringBuilder curr, int index) {
        if (digits.length() == index) {
            combinations.add(curr.toString());
            return;
        }

        List<Character> letters = numToLettersMap.get(digits.charAt(index));
        for (char letter : letters) {
            curr.append(letter);
            backtrack(digits, combinations, curr, index + 1);
            curr.deleteCharAt(curr.length() - 1);
        }
    }

    private static final Map<Character, List<Character>> numToLettersMap = Map.of(
            '2', List.of('a', 'b', 'c'),
            '3', List.of('d', 'e', 'f'),
            '4', List.of('g', 'h', 'i'),
            '5', List.of('j', 'k', 'l'),
            '6', List.of('m', 'n', 'o'),
            '7', List.of('p', 'q', 'r', 's'),
            '8', List.of('t', 'u', 'v'),
            '9', List.of('w', 'x', 'y', 'z')
    );
}
