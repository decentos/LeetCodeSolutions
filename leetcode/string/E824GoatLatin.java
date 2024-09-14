package string;

public class E824GoatLatin {

    public String toGoatLatin(String sentence) {
        StringBuilder converted = new StringBuilder();
        StringBuilder suffix = new StringBuilder("a");
        String[] words = sentence.split("\\s");

        for (String word : words) {
            StringBuilder curr;

            if (isVowel(word.charAt(0))) {
                curr = new StringBuilder(word);
            } else {
                curr = new StringBuilder(word.substring(1)).append(word.charAt(0));
            }
            curr.append("ma").append(suffix).append(" ");
            converted.append(curr);
            suffix.append("a");
        }
        return converted.toString().trim();
    }

    private boolean isVowel(char letter) {
        return letter == 'a' || letter == 'e' || letter == 'i' || letter == 'o' || letter == 'u'
                || letter == 'A' || letter == 'E' || letter == 'I' || letter == 'O' || letter == 'U';
    }
}
