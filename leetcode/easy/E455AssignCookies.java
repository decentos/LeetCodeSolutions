package easy;

import java.util.Arrays;

public class E455AssignCookies {

    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int cookieIndex = 0, childIndex = 0;

        while (childIndex < g.length && cookieIndex < s.length) {
            if (g[childIndex] <= s[cookieIndex]) {
                childIndex++;
            }
            cookieIndex++;
        }
        return childIndex;
    }
}
