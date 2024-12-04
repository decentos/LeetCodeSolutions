package string;

public class M2825SubseqCyclicIncrements {

    public boolean canMakeSubsequence(String str1, String str2) {
        int i1 = 0, i2 = 0;

        while (i1 < str1.length() && i2 < str2.length()) {
            char c1 = str1.charAt(i1), c2 = str2.charAt(i2);
            if (c1 == c2 || c1 + 1 == c2 || c1 - 25 == c2) {
                i2++;
            }
            i1++;
        }
        return i2 == str2.length();
    }
}
