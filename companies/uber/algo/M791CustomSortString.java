package uber.algo;

public class M791CustomSortString {

    public String customSortString(String order, String s) {
        int n = s.length();
        char[] sorted = new char[n];
        int insertIndex = 0;
        int[] freq = new int[26];

        for (char letter : s.toCharArray()) {
            freq[letter - 'a']++;
        }

        for (char curr : order.toCharArray()) {
            while (freq[curr - 'a'] > 0) {
                sorted[insertIndex++] = curr;
                freq[curr - 'a']--;
            }
        }

        for (int i = 0; i < freq.length; i++) {
            while (freq[i] > 0) {
                char curr = (char) (i + 'a');
                sorted[insertIndex++] = curr;
                freq[i]--;
            }
        }
        return String.valueOf(sorted);
    }
}
