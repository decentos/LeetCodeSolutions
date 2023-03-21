package easy;

import java.util.List;

public class E422ValidWordSquare {

    public boolean validWordSquare(List<String> words) {
        for (int wordPos = 0; wordPos < words.size(); wordPos++) {
            for (int charPos = 0; charPos < words.get(wordPos).length(); charPos++) {
                if (charPos >= words.size()
                        || wordPos >= words.get(charPos).length()
                        || words.get(wordPos).charAt(charPos) != words.get(charPos).charAt(wordPos)) {
                    return false;
                }
            }
        }
        return true;
    }
}
