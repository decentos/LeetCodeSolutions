package string;

public class E1662CheckStringInArrays {

    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuilder arr1 = new StringBuilder();
        StringBuilder arr2 = new StringBuilder();
        for (String word : word1) {
            arr1.append(word);
        }
        for (String word : word2) {
            arr2.append(word);
        }
        return arr1.toString().equals(arr2.toString());
    }

    public boolean arrayStringsAreEqual2(String[] word1, String[] word2) {
        if (word1.length == 0 || word2.length == 0) return false;
        return String.join("", word1).equals(String.join("", word2));
    }

    public boolean arrayStringsAreEqual3(String[] word1, String[] word2) {
        if (word1.length == 0 || word2.length == 0) return false;
        StringBuilder arr1 = new StringBuilder();
        StringBuilder arr2 = new StringBuilder();
        for (int i = 0; i < Math.max(word1.length, word2.length); i++) {
            if (i < word1.length) {
                arr1.append(word1[i]);
            }

            if (i < word2.length) {
                arr2.append(word2[i]);
            }
        }
        return arr1.toString().equals(arr2.toString());
    }
}
