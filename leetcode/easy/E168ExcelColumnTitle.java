package easy;

public class E168ExcelColumnTitle {

    public String convertToTitle(int columnNumber) {
        StringBuilder title = new StringBuilder();
        while (columnNumber != 0) {
            columnNumber--;
            int offset = columnNumber % 26;
            char letter = (char) ('A' + offset);
            title.append(letter);
            columnNumber /= 26;
        }
        return title.reverse().toString();
    }
}
