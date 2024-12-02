package string;

public class E1455WordOccursAsPrefix {

    public int isPrefixOfWord(String sentence, String searchWord) {
        String[] words = sentence.split("\\s");
        for (int i = 0; i < words.length; i++) {
            if (words[i].startsWith(searchWord)) {
                return i + 1;
            }
        }
        return -1;
    }
}
