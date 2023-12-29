package string;

public class M443StringCompression {

    public int compress(char[] chars) {
        int n = chars.length;
        int insertedIndex = 0, index = 0;

        while (index < n) {
            char curr = chars[index];
            int count = 0;
            while (index < n && chars[index] == curr) {
                count++;
                index++;
            }

            chars[insertedIndex++] = curr;
            if (count > 1) {
                char[] temp = String.valueOf(count).toCharArray();
                for (char c : temp) {
                    chars[insertedIndex++] = c;
                }
            }
        }
        return insertedIndex;
    }
}
