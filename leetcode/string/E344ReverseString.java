package string;

public class E344ReverseString {

    public void reverseString(char[] s) {
        int l = 0, r = s.length - 1;
        while (l < r) {
            char curr = s[l];
            s[l] = s[r];
            s[r] = curr;
            l++;
            r--;
        }
    }
}
