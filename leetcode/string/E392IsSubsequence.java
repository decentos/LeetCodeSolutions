package string;

public class E392IsSubsequence {

    public boolean isSubsequence(String s, String t) {
        int sub = 0, word = 0;

        while (sub < s.length() && word < t.length()) {
            if (s.charAt(sub) == t.charAt(word)) {
                sub++;
            }
            word++;
        }
        return sub == s.length();
    }
}
