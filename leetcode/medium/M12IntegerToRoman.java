package medium;

import java.util.Map;
import java.util.TreeMap;

public class M12IntegerToRoman {

    public String intToRoman(int num) {
        StringBuilder roman = new StringBuilder();
        int multiplier = 1;

        while (num > 0) {
            int curr = num % 10 * multiplier;
            int insertIndex = 0;

            while (curr > 0) {
                Map.Entry<Integer, String> entry = intToRoman.floorEntry(curr);
                roman.insert(insertIndex, entry.getValue());
                insertIndex++;
                curr -= entry.getKey();
            }

            multiplier *= 10;
            num /= 10;
        }
        return roman.toString();
    }

    private static final TreeMap<Integer, String> intToRoman = new TreeMap<>();
    static {
        intToRoman.put(1, "I");
        intToRoman.put(4, "IV");
        intToRoman.put(5, "V");
        intToRoman.put(9, "IX");
        intToRoman.put(10, "X");
        intToRoman.put(40, "XL");
        intToRoman.put(50, "L");
        intToRoman.put(90, "XC");
        intToRoman.put(100, "C");
        intToRoman.put(400, "CD");
        intToRoman.put(500, "D");
        intToRoman.put(900, "CM");
        intToRoman.put(1000, "M");
    }
}
