package slidingwindow;

public class M3LongestSubstring {

    public int lengthOfLongestSubstring(String s) {
        int[] used = new int[128];
        int maxLength = 0, left = 0;

        for (int right = 0; right < s.length(); right++) {
            while (used[s.charAt(right)] > 0) {
                used[s.charAt(left)]--;
                left++;
            }
            used[s.charAt(right)]++;
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }
}
