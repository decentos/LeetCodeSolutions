package booking;

import java.util.Map;

public class E13RomanToInt {

    public int romanToInt(String s) {
        char[] roman = s.toCharArray();
        int currIndex = 0, converted = 0;

        while (currIndex < roman.length) {
            int nextIndex = currIndex < roman.length - 1 ? currIndex + 1 : currIndex;
            int currInt = romanToInt.get(roman[currIndex]);
            int nextInt = romanToInt.get(roman[nextIndex]);

            if (nextInt > currInt) {
                converted += nextInt - currInt;
                currIndex += 2;
            } else {
                converted += currInt;
                currIndex++;
            }
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
