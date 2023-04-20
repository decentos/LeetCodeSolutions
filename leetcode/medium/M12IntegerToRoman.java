package medium;

import java.util.Map;
import java.util.TreeMap;

public class M12IntegerToRoman {

    public String intToRoman(int num) {
        StringBuilder roman = new StringBuilder();
        int digit = 1;

        while (num != 0) {
            int key = num % 10 * digit;
            int insertIndex = 0;

            while (key != 0) {
                Map.Entry<Integer, String> floor = arabic.floorEntry(key);
                roman.insert(insertIndex, floor.getValue());
                insertIndex++;
                key -= floor.getKey();
            }

            num /= 10;
            digit *= 10;
        }
        return roman.toString();
    }

    private static final TreeMap<Integer, String> arabic = new TreeMap<>();
    static {
        arabic.put(1, "I");
        arabic.put(4, "IV");
        arabic.put(5, "V");
        arabic.put(9, "IX");
        arabic.put(10, "X");
        arabic.put(40, "XL");
        arabic.put(50, "L");
        arabic.put(90, "XC");
        arabic.put(100, "C");
        arabic.put(400, "CD");
        arabic.put(500, "D");
        arabic.put(900, "CM");
        arabic.put(1000, "M");
    }
}
