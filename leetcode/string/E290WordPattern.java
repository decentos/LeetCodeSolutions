package string;

import java.util.HashMap;
import java.util.Map;

public class E290WordPattern {

    public boolean wordPattern(String pattern, String s) {
        Map<Character, String> letterToWord = new HashMap<>();
        Map<String, Character> wordToLetter = new HashMap<>();
        String[] words = s.split("\\s");

        if (words.length != pattern.length()) {
            return false;
        }

        for (int i = 0; i < words.length; i++) {
            char letter = pattern.charAt(i);
            String word = words[i];

            if (!letterToWord.containsKey(letter) && !wordToLetter.containsKey(word)) {
                letterToWord.put(letter, word);
                wordToLetter.put(word, letter);
            } else if (!letterToWord.containsKey(letter) || !wordToLetter.containsKey(word)
                    || !letterToWord.get(letter).equals(word) || wordToLetter.get(word) != letter) {
                return false;
            }
        }
        return true;
    }
}
