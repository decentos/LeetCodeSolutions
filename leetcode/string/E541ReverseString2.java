package string;

public class E541ReverseString2 {

    public String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();
        for (int start = 0; start < chars.length; start += 2 * k) {
            int l = start, r = Math.min(start + k - 1, chars.length - 1);
            while (l < r) {
                char temp = chars[l];
                chars[l] = chars[r];
                chars[r] = temp;
                l++;
                r--;
            }
        }
        return String.valueOf(chars);
    }
}
