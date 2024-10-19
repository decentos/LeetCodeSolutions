package string;

import java.util.ArrayList;
import java.util.List;

public class H68TextJustification {

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> ans = new ArrayList<>();
        List<String> curr = new ArrayList<>();
        int currLen = 0, currSpaces = 0;

        for (String word : words) {
            if (currLen + word.length() + currSpaces <= maxWidth) {
                curr.add(word);
                currLen += word.length();
                currSpaces++;
            } else {
                if (curr.size() == 1) {
                    int spacesCount = maxWidth - currLen;
                    ans.add(String.join(" ", curr) + " ".repeat(spacesCount));
                } else {
                    String line = getLine(maxWidth, currLen, curr);
                    ans.add(line);
                }

                currSpaces = 1;
                currLen = word.length();
                curr.clear();
                curr.add(word);
            }
        }

        int spacesCount = maxWidth - currLen - curr.size() + 1;
        ans.add(String.join(" ", curr) + " ".repeat(spacesCount));
        return ans;
    }

    private String getLine(int maxWidth, int currLen, List<String> curr) {
        int spacesCount = maxWidth - currLen;
        int normalSpaces = spacesCount / (curr.size() - 1);
        int extraSpaces = spacesCount % (curr.size() - 1);
        StringBuilder line = new StringBuilder();

        for (int i = 0; i < curr.size(); i++) {
            line.append(curr.get(i));
            if (i < curr.size() - 1) {
                line.append(" ".repeat(normalSpaces));
            }
            if (extraSpaces > 0) {
                line.append(" ");
                extraSpaces--;
            }
        }
        return line.toString();
    }
}
