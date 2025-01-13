package medium;

public class M2657PrefixCommonArray {

    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length, currPrefix = 0;
        int[] commonPrefix = new int[n];
        boolean[] seen = new boolean[n + 1];

        for (int i = 0; i < n; i++) {
            if (seen[A[i]]) {
                currPrefix++;
            } else {
                seen[A[i]] = true;
            }

            if (seen[B[i]]) {
                currPrefix++;
            } else {
                seen[B[i]] = true;
            }

            commonPrefix[i] = currPrefix;
        }
        return commonPrefix;
    }
}
