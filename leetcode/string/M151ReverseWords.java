package string;

public class M151ReverseWords {

    public String reverseWords(String s) {
        String[] split = s.trim().split("\\s+");
        int left = 0, right = split.length - 1;

        while (left < right) {
            String temp = split[left];
            split[left] = split[right];
            split[right] = temp;
            left++;
            right--;
        }
        return String.join(" ", split);
    }
}
