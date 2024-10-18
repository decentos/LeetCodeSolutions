package twopointers;

public class E392IsSubsequence {

    public boolean isSubsequence(String s, String t) {
        int sLen = s.length(), tLen = t.length();
        int sIndex = 0, tIndex = 0;

        while (tIndex < tLen && sIndex < sLen) {
            if (s.charAt(sIndex) == t.charAt(tIndex)) {
                sIndex++;
            }
            tIndex++;
        }
        return sIndex == sLen;
    }
}
