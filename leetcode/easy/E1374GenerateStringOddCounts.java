package easy;

import java.util.Arrays;

public class E1374GenerateStringOddCounts {

    public String generateTheString(int n) {
        char[] s = new char[n];
        Arrays.fill(s, 'a');
        if (n % 2 == 0) {
            s[0] = 'b';
        }
        return String.valueOf(s);
    }
}
