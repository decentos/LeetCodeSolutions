package string;

public class E1768MergeStringsAlternately {

    public String mergeAlternately(String word1, String word2) {
        StringBuilder merged = new StringBuilder();
        int n1 = word1.length(), n2 = word2.length();
        int ptr1 = 0, ptr2 = 0, index = 0;

        while (ptr1 < n1 && ptr2 < n2) {
            if (index % 2 == 0) {
                merged.append(word1.charAt(ptr1++));
            } else {
                merged.append(word2.charAt(ptr2++));
            }
            index++;
        }

        if (ptr1 < n1) {
            merged.append(word1, ptr1, n1);
        }

        if (ptr2 < n2) {
            merged.append(word2, ptr2, n2);
        }

        return merged.toString();
    }
}
