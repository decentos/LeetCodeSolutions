package uber.algo;

import java.util.ArrayList;
import java.util.List;

public class H68TextJustification {

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> ans = new ArrayList<>();
        List<String> row = new ArrayList<>();
        int rowLength = 0, spacesCount = 0;

        for (String word : words) {
            if (word.length() + rowLength + spacesCount <= maxWidth) {
                row.add(word);
                rowLength += word.length();
                spacesCount++;
            } else {
                int rowSpaces = maxWidth - rowLength;
                if (row.size() == 1) {
                    ans.add(String.join(" ", row) + " ".repeat(rowSpaces));
                } else {
                    String line = getLine(row, rowSpaces);
                    ans.add(line);
                }

                row.clear();
                row.add(word);
                rowLength = word.length();
                spacesCount = 1;
            }
        }

        int extraSpaces = maxWidth - rowLength - row.size() + 1;
        String lastRow = String.join(" ", row) + " ".repeat(extraSpaces);
        ans.add(lastRow);
        return ans;
    }

    private String getLine(List<String> row, int rowSpaces) {
        int normalSpaces = rowSpaces / (row.size() - 1);
        int extraSpaces = rowSpaces % (row.size() - 1);

        StringBuilder line = new StringBuilder();

        for (int i = 0; i < row.size(); i++) {
            String word = row.get(i);
            line.append(word);

            if (i < row.size() - 1) {
                line.append(" ".repeat(normalSpaces));

                if (extraSpaces > 0) {
                    line.append(" ");
                    extraSpaces--;
                }
            }
        }
        return line.toString();
    }
}
