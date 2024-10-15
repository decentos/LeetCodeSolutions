package string;

public class E14CommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        String first = strs[0];

        for (int i = 0; i < first.length(); i++) {
            char currChar = first.charAt(i);
            for (String word : strs) {
                if (word.length() <= i || word.charAt(i) != currChar) {
                    return first.substring(0, i);
                }
            }
        }
        return first;
    }
}
