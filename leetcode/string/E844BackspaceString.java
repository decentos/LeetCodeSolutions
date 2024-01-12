package string;

public class E844BackspaceString {

    public boolean backspaceCompare(String s, String t) {
        int n1 = s.length(), n2 = t.length();
        int ptr1 = n1 - 1, ptr2 = n2 - 1;
        int skip1 = 0, skip2 = 0;

        while (ptr1 >= 0 || ptr2 >= 0) {
            while (ptr1 >= 0 && (s.charAt(ptr1) == '#' || skip1 > 0)) {
                skip1 += s.charAt(ptr1) == '#' ? 1 : -1;
                ptr1--;
            }
            while (ptr2 >= 0 && (t.charAt(ptr2) == '#' || skip2 > 0)) {
                skip2 += t.charAt(ptr2) == '#' ? 1 : -1;
                ptr2--;
            }

            if (ptr1 >= 0 && ptr2 >= 0 && s.charAt(ptr1) == t.charAt(ptr2)) {
                ptr1--;
                ptr2--;
            } else {
                break;
            }
        }
        return ptr1 < 0 && ptr2 < 0;
    }
}
