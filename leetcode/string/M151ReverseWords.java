package string;

public class M151ReverseWords {

    public String reverseWords(String s) {
        String[] splitted = s.trim().split("\\s+");
        StringBuilder reversed = new StringBuilder();

        for (int i = splitted.length - 1; i >= 0; i--) {
            reversed.append(splitted[i]).append(" ");
        }
        return reversed.toString().trim();
    }
}
