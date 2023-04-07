package string;

public class M3LongestSubstring {

    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;

        int max = 0;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char next = s.charAt(i);
            int nextIndex = sb.indexOf(String.valueOf(next));
            if (nextIndex >= 0) {
                max = Math.max(max, sb.length());
                sb.delete(0, nextIndex + 1);
            }
            sb.append(next);
        }
        return Math.max(max, sb.length());
    }

    public int lengthOfLongestSubstring2(String s) {
        int[] chars = new int[128];
        int left = 0, right = 0, max = 0;

        while (right < s.length()) {
            char r = s.charAt(right);
            chars[r]++;

            while (chars[r] > 1) {
                char l = s.charAt(left);
                chars[l]--;
                left++;
            }
            max = Math.max(max, right - left + 1);
            right++;
        }
        return max;
    }

    public int lengthOfLongestSubstring3(String s) {
        Integer[] chars = new Integer[128];
        int left = 0, right = 0, max = 0;

        while (right < s.length()) {
            char r = s.charAt(right);
            Integer index = chars[r];
            if (index != null && index >= left && index < right) left = index + 1;

            max = Math.max(max, right - left + 1);
            chars[r] = right;
            right++;
        }
        return max;
    }
}
