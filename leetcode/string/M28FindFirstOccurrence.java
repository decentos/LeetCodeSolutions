package string;

public class M28FindFirstOccurrence {

    public int strStr(String haystack, String needle) {
        if (haystack.equals(needle)) return 0;
        int n = haystack.length(), m = needle.length();
        if (n < m) return -1;

        int p1 = 0, p2 = 0;
        while (p1 < n - m + 1) {
            int temp = p1;
            while (p2 < m) {
                if (haystack.charAt(temp) == needle.charAt(p2)) {
                    temp++;
                    p2++;
                } else {
                    p2 = 0;
                    p1++;
                    break;
                }
            }
            if (p2 == m) {
                return p1;
            }
        }
        return -1;
    }

    public int strStr2(String haystack, String needle) {
        return haystack.indexOf(needle);
    }

    public int strStrKMP(String haystack, String needle) {
        if (haystack.equals(needle)) return 0;
        int n = haystack.length(), m = needle.length();
        if (n < m) return -1;

        int[] f = failureFunction(needle.toCharArray());
        int i = 0, j = 0;
        while (i < n) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
                if (j == needle.length()) {
                    return i - j;
                }
            } else if (j > 0) {
                j = f[j];
            } else {
                i++;
            }
        }
        return -1;
    }

    private int[] failureFunction(char[] str) {
        int[] f = new int[str.length + 1];
        for (int i = 2; i < f.length; i++) {
            int j = f[i - 1];
            while (j > 0 && str[j] != str[i - 1]) j = f[j];
            if (j > 0 || str[j] == str[i - 1]) f[i] = j + 1;
        }
        return f;
    }
}
