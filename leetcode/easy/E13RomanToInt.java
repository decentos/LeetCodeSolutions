package easy;

import java.util.Map;

public class E13RomanToInt {

    public int romanToInt(String s) {
        int n = s.length(), index = 0;
        int converted = 0;

        while (index < n - 1) {
            int curr = romanToInt.get(s.charAt(index));
            int next = romanToInt.get(s.charAt(index + 1));
            if (curr < next) {
                converted += next - curr;
                index += 2;
            } else {
                converted += curr;
                index++;
            }
        }

        if (index < n) {
            converted += romanToInt.get(s.charAt(index));
        }
        return converted;
    }

    private final Map<Character, Integer> romanToInt = Map.of(
            'I', 1,
            'V', 5,
            'X', 10,
            'L', 50,
            'C', 100,
            'D', 500,
            'M', 1000
    );
}
