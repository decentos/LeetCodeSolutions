package string;

public class M6ZigzagConversion {

    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        StringBuilder zigzag = new StringBuilder();
        int n = s.length(), sectionSize = 2 * numRows - 2;

        for (int row = 0; row < numRows; row++) {
            int index = row;

            while (index < n) {
                zigzag.append(s.charAt(index));

                if (row != 0 && row != numRows - 1) {
                    int nextStep = sectionSize - 2 * row;
                    int nextIndex = index + nextStep;

                    if (nextIndex < n) {
                        zigzag.append(s.charAt(nextIndex));
                    }
                }
                index += sectionSize;
            }
        }
        return zigzag.toString();
    }
}
