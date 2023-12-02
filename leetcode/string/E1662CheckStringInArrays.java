package string;

public class E1662CheckStringInArrays {

    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        String str1 = String.join("", word1);
        String str2 = String.join("", word2);
        return str1.equals(str2);
    }

// ===============================================================================

    public boolean arrayStringsAreEqual2(String[] word1, String[] word2) {
        int index1 = 0, index2 = 0;
        int ptr1 = 0, ptr2 = 0;

        while (index1 < word1.length && index2 < word2.length) {
            if (word1[index1].charAt(ptr1++) != word2[index2].charAt(ptr2++)) {
                return false;
            }
            if (ptr1 == word1[index1].length()) {
                index1++;
                ptr1 = 0;
            }
            if (ptr2 == word2[index2].length()) {
                index2++;
                ptr2 = 0;
            }
        }
        return index1 == word1.length && index2 == word2.length;
    }
}
