package counting;

public class E383RansomNote {

    public boolean canConstruct(String ransomNote, String magazine) {
        int[] freq = new int[26];

        for (char letter : magazine.toCharArray()) {
            freq[letter - 'a']++;
        }

        for (char letter : ransomNote.toCharArray()) {
            if (freq[letter - 'a'] == 0) {
                return false;
            }
            freq[letter - 'a']--;
        }
        return true;
    }
}
