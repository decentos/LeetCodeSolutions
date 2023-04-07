package string;

public class M151ReverseWords {

    public String reverseWords(String s) {
        s = s.trim();
        String[] arr = s.split("\\s+");
        int l = 0, r = arr.length - 1;
        while (l < r) {
            String temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            l++;
            r--;
        }
        return String.join(" ", arr);
    }
}
