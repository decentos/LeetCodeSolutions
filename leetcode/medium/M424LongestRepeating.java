package medium;

public class M424LongestRepeating {

    public static int characterReplacement(String s, int k) {
        int[] arr = new int[26];
        int largestCount = 0, start = 0, max = 0;

        for (int end = 0; end < s.length(); end++) {
            arr[s.charAt(end) - 'A']++;
            largestCount = Math.max(largestCount, arr[s.charAt(end) - 'A']);

            if (end - start + 1 - largestCount > k) {
                arr[s.charAt(start) - 'A']--;
                start++;
            }
            max = Math.max(max, end - start + 1);
        }
        return max;
    }
}
