package string;

public class M443StringCompression {

    public int compress(char[] chars) {
        int n = chars.length;
        int index = 0, insertIndex = 0;

        while (index < n) {
            char curr = chars[index++];
            int repeat = 1;

            while (index < n && chars[index] == curr) {
                index++;
                repeat++;
            }

            chars[insertIndex++] = curr;
            if (repeat > 1 && repeat < 10) {
                chars[insertIndex++] = Character.forDigit(repeat, 10);
            } else if (repeat >= 10) {
                String repeatStr = String.valueOf(repeat);
                for (char digit : repeatStr.toCharArray()) {
                    chars[insertIndex++] = digit;
                }
            }
        }
        return insertIndex;
    }
}
