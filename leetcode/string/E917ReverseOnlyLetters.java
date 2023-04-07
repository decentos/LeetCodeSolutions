package string;

public class E917ReverseOnlyLetters {

    public String reverseOnlyLetters(String s) {
        char[] arr = s.toCharArray();
        int left = 0, right = arr.length - 1;
        while (left < right) {
            while (left < right && Character.isLetter(arr[left]) && Character.isLetter(arr[right])) {
                char temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }

            while (left < right && !Character.isLetter(arr[left])) left++;
            while (right >= 0 && !Character.isLetter(arr[right])) right--;
        }
        return String.valueOf(arr);
    }
}
