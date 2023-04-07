package string;

public class M443StringCompression {

    public int compress(char[] chars) {
        StringBuilder result = new StringBuilder();
        int count = 1, i = 0;

        while (i < chars.length) {
            while (i < chars.length - 1 && chars[i] == chars[i + 1]) {
                count++;
                i++;
            }
            result.append(chars[i]);
            if (count > 1) {
                result.append(count);
                count = 1;
            }
            i++;
        }
        for (int j = 0; j < result.length(); j++) {
            chars[j] = result.charAt(j);
        }
        return result.length();
    }
}
