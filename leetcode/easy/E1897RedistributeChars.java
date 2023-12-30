package easy;

public class E1897RedistributeChars {

    public boolean makeEqual(String[] words) {
        int[] counter = new int[26];

        for (String word : words) {
            for (char letter : word.toCharArray()) {
                counter[letter - 'a']++;
            }
        }

        for (int curr : counter) {
            if (curr % words.length != 0) {
                return false;
            }
        }
        return true;
    }
}
