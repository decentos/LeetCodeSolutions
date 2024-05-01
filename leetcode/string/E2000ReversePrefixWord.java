package string;

public class E2000ReversePrefixWord {

    public String reversePrefix(String word, char ch) {
        char[] reverted = word.toCharArray();
        swap(reverted, 0, word.indexOf(ch));
        return String.valueOf(reverted);
    }

    private void swap(char[] arr, int start, int end) {
        while (start < end) {
            char temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}
