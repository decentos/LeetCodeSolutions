package string;

public class E392IsSubsequence {

    public static boolean isSubsequence(String s, String t) {
        if (s.length() == 0) return true;
        if (t.length() == 0) return false;

        int sub = 0, word = 0;
        while (sub < s.length() && word < t.length()) {
            if (s.charAt(sub) == t.charAt(word)) {
                sub++;
            }
            word++;
        }
        return sub == s.length();
    }

    public boolean isSubsequence2(String s, String t) {
        int i2 = 0;
        for (int i1 = 0; i1 < t.length(); i1++) {
            if (i2 == s.length()) break;
            if (t.charAt(i1) == s.charAt(i2)) i2++;
        }
        return i2 == s.length();
    }
}
