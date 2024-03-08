package twopointers;

public class M1750MinLenAfterDeleting {

    public int minimumLength(String s) {
        int left = 0, right = s.length() - 1;

        while (left < right && s.charAt(left) == s.charAt(right)) {
            char curr = s.charAt(left);
            while (left <= right && s.charAt(left) == curr) {
                left++;
            }
            while (left < right && s.charAt(right) == curr) {
                right--;
            }
        }
        return right - left + 1;
    }
}
