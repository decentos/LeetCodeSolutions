package string;

public class E557ReverseWords3 {

    public String reverseWords(String s) {
        int lastSpace = -1;
        char[] arr = s.toCharArray();
        for (int i = 0; i <= arr.length; i++) {
            if (i == arr.length || arr[i] == ' ') {
                int start = lastSpace + 1, end = i - 1;
                while (start < end) {
                    char left = arr[start];
                    arr[start] = arr[end];
                    arr[end] = left;
                    start++;
                    end--;
                }
                lastSpace = i;
            }
        }
        return String.valueOf(arr);
    }
}
