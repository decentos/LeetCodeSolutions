package easy;

import java.util.Map;

public class E13RomanToInt {

    public int romanToInt(String s) {
        int n = s.length(), arabic = 0, index = 0;

        while (index < n) {
            if (index < n - 1) {
                int curr = roman.get(s.charAt(index));
                int next = roman.get(s.charAt(index + 1));

                if (next > curr) {
                    arabic += next - curr;
                    index += 2;
                } else {
                    arabic += curr;
                    index++;
                }
            } else {
                arabic += roman.get(s.charAt(index));
                index++;
            }
        }
        return arabic;
    }

    private static final Map<Character, Integer> roman = Map.of(
            'I', 1,
            'V', 5,
            'X', 10,
            'L', 50,
            'C', 100,
            'D', 500,
            'M', 1000
    );
}
