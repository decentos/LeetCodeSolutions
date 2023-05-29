package string;

public class M161OneEditDistance {

    public boolean isOneEditDistance(String s, String t) {
        int sLength = s.length(), tLength = t.length();
        if (sLength > tLength) return isOneEditDistance(t, s);
        if (s.equals(t) || tLength - sLength > 1) return false;

        for (int i = 0; i < sLength; i++) {
            if (s.charAt(i) != t.charAt(i)) {
                if (sLength == tLength) return s.substring(i + 1).equals(t.substring(i + 1));
                else return s.substring(i).equals(t.substring(i + 1));
            }
        }
        return sLength + 1 == tLength;
    }
}
