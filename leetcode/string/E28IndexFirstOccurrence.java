package string;

public class E28IndexFirstOccurrence {

    public int strStr(String haystack, String needle) {
        int hLen = haystack.length(), nLen = needle.length();
        int hIndex = 0, nIndex = 0;

        while (hIndex < hLen) {
            if (haystack.charAt(hIndex) == needle.charAt(nIndex)) {
                nIndex++;
            } else {
                hIndex -= nIndex;
                nIndex = 0;
            }

            if (nIndex == nLen) {
                return hIndex - nLen + 1;
            } else {
                hIndex++;
            }
        }
        return -1;
    }
}
